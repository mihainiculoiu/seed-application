package com.softium.assignment.database.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.softium.assignment.service.core.place.PlaceConstants.PLACE_ID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceEntityMother {

    public static PlaceEntity completePlaceEntity() {
        return PlaceEntity.builder()
                .id(UUID.fromString(PLACE_ID))
                .build();
    }

}
