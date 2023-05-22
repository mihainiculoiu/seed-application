package com.softium.assignment.web.api.place;

import com.softium.assignment.web.api.place.response.PlaceDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.softium.assignment.service.core.place.PlaceConstants.PLACE_ID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceDtoMother {

    public static PlaceDto complete() {
        return PlaceDto.builder()
                .id(PLACE_ID)
                .build();
    }

}
