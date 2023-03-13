package com.veracityid.assignment.service.core.place;

import com.veracityid.assignment.service.core.model.Place;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.veracityid.assignment.service.core.place.PlaceConstants.PLACE_ID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceMother {

    public static Place complete() {
        return Place.builder()
                .id(PLACE_ID)
                .build();
    }
}
