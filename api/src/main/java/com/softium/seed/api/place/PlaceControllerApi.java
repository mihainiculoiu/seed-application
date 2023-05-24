package com.softium.seed.api.place;

import com.softium.seed.api.place.response.PlaceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Place API", description = "operations to manage places")
@RestController
public interface PlaceControllerApi {

    @Operation(summary = "Get a Place", description = "get a place by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved Place", content = @Content(schema = @Schema(implementation = PlaceDto.class))),
            @ApiResponse(responseCode = "404", description = "The resource was not found."),
            @ApiResponse(responseCode = "500", description = "There was an error when processing your request.")
    })
    @Parameter(name = "placeId", description = "place id value", schema = @Schema(type = "string"), example = "ECB8FDD8-5666-4C51-AA22-0010A54F7E41")
    ResponseEntity<PlaceDto> getPlace(@PathVariable String placeId);

}
