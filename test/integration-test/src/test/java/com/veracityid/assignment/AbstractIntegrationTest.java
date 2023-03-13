package com.veracityid.assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.veracityid.assignment.database.repository.PlaceRepository;
import com.veracityid.assignment.web.api.GlobalExceptionHandler;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {TestApplication.class, GlobalExceptionHandler.class})
@AutoConfigureWireMock(port = 0, httpsPort = 0)
@ActiveProfiles("test")
@Slf4j
public abstract class AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected WireMockServer wireMockServer;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PlaceRepository placeRepository;

    @BeforeEach
    void beforeEach() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @AfterEach
    void reset() {
        cleanDatabase();
    }

    protected void cleanDatabase() {
        placeRepository.deleteAll();
    }

    protected void stubUrlWithStatus(MappingBuilder mappingBuilder, HttpStatus httpStatus, Object responseBody) {
        stubUrlWithStatus(mappingBuilder, null, httpStatus, responseBody);
    }

    @SneakyThrows
    protected void stubUrlWithStatus(MappingBuilder mappingBuilder, Object requestBody, HttpStatus httpStatus, Object responseBody) {
        addRequest(mappingBuilder, requestBody);
        addResponse(mappingBuilder, httpStatus, responseBody);
        wireMockServer.stubFor(mappingBuilder);
    }

    private void addRequest(MappingBuilder mappingBuilder, Object requestBody) throws JsonProcessingException {
        if (Objects.nonNull(requestBody)) {
            mappingBuilder
                    .withHeader(CONTENT_TYPE, equalTo(APPLICATION_JSON_VALUE))
                    .withRequestBody(equalToJson(objectMapper.writeValueAsString(requestBody)));
        }
    }

    private void addResponse(MappingBuilder mappingBuilder, HttpStatus httpStatus, Object responseBody) throws JsonProcessingException {
        ResponseDefinitionBuilder response = aResponse()
                .withHeader("Connection", "close")
                .withStatus(httpStatus.value());

        if (Objects.nonNull(responseBody)) {
            response.withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                    .withBody(objectMapper.writeValueAsString(responseBody));
        }

        mappingBuilder.willReturn(response);
    }

}
