package com.softium.seed.domain.core;

import com.softium.seed.domain.core.model.Place;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.softium.seed.domain.core.PlaceConstants.PLACE_ID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceMother {

    public static Place complete() {
        return Place.builder()
                .id(PLACE_ID)
                .build();
    }
}
