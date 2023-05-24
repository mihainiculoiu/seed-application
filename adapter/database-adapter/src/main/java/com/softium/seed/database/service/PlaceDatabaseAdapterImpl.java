package com.softium.seed.database.service;

import com.softium.seed.database.entity.PlaceEntity;
import com.softium.seed.database.repository.PlaceRepository;
import com.softium.seed.database.repository.mapper.PlaceEntityMapper;
import com.softium.seed.domain.adapter.database.PlaceDatabaseAdapter;
import com.softium.seed.domain.core.exception.ResourceNotFoundException;
import com.softium.seed.domain.core.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlaceDatabaseAdapterImpl implements PlaceDatabaseAdapter {

    public final String PLACE_NOT_FOUND_BY_ID_ERROR_MESSAGE = "Place not found for id: %s.";

    private final PlaceRepository placeRepository;
    private final PlaceEntityMapper placeEntityMapper;

    @Override
    public Place getPlaceById(String placeId) {
        PlaceEntity placeEntity = placeRepository.findById(UUID.fromString(placeId))
                .orElseThrow(() -> new ResourceNotFoundException(String.format(PLACE_NOT_FOUND_BY_ID_ERROR_MESSAGE, placeId)));

        return placeEntityMapper.toDomain(placeEntity);
    }

}
