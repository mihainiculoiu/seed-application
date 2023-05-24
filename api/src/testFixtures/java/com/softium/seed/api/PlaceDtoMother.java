package com.softium.seed.api;

import com.softium.seed.api.place.response.PlaceDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.softium.seed.domain.core.PlaceConstants.PLACE_ID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceDtoMother {

    public static PlaceDto complete() {
        return PlaceDto.builder()
                .id(PLACE_ID)
                .build();
    }

}
