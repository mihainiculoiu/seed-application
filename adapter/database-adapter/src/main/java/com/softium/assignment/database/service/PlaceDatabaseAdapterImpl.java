package com.softium.assignment.database.service;

import com.softium.assignment.database.repository.PlaceRepository;
import com.softium.assignment.service.adapter.database.PlaceDatabaseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceDatabaseAdapterImpl implements PlaceDatabaseAdapter {

    private final PlaceRepository placeRepository;

}
