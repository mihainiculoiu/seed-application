package com.softium.seed.domain.core.service;

import com.softium.seed.domain.adapter.database.PlaceDatabaseAdapter;
import com.softium.seed.domain.core.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService {

    private final PlaceDatabaseAdapter placeDatabaseAdapter;

    public Place getPlaceById(String placeId) {
        return placeDatabaseAdapter.getPlaceById(placeId);
    }

}
