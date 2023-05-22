package com.softium.seed.web.config;

import com.softium.seed.web.api.ErrorResponse;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "seed API",
        description = "Application that provides API for Assigment",
        license = @License(name = "seed API", url = "https://assignemnt-application.index.html"),
        version = "1.0",
        contact = @Contact(name = "Mihai Niculoiu", url = "https://www.linkedin.com/in/mihai-niculoiu/", email = "mihainiculoiu@gmail.com")))
public class SwaggerConfig {

    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .addOpenApiCustomiser((openApiCustomiser()))
                .group("v1")
                .pathsToMatch("/**")
                .pathsToExclude("/actuator/**", "/errors/**")
                .build();
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> {
            openApi.getComponents().getSchemas().putAll(ModelConverters.getInstance().read(ErrorResponse.class));
            Schema<Object> errorResponseSchema = new Schema<>();
            errorResponseSchema.setName("ErrorResponse");
            errorResponseSchema.set$ref("#/components/schemas/ErrorResponse");

            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();
                apiResponses.addApiResponse("400", createApiResponse("Bad Request", errorResponseSchema));
                apiResponses.addApiResponse("401", createApiResponse("Unauthorised", errorResponseSchema));
                apiResponses.addApiResponse("403", createApiResponse("Forbidden", errorResponseSchema));
                apiResponses.addApiResponse("404", createApiResponse("Not Found", errorResponseSchema));
                apiResponses.addApiResponse("500", createApiResponse("Server Error", errorResponseSchema));
            }));
        };
    }

    private ApiResponse createApiResponse(String message, Schema<Object> schema) {
        MediaType mediaType = new MediaType();
        mediaType.schema(schema);
        return new ApiResponse().description(message)
                .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, mediaType));
    }

}
