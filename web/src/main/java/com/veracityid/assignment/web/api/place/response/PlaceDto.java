package com.veracityid.assignment.web.api.place.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@Builder
@Schema(description = "Place response")
public class PlaceDto {

    String id;

}
