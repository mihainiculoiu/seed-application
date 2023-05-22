package com.softium.seed.database.service;

import com.softium.seed.database.repository.PlaceRepository;
import com.softium.seed.domain.adapter.database.PlaceDatabaseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceDatabaseAdapterImpl implements PlaceDatabaseAdapter {

    private final PlaceRepository placeRepository;

}
