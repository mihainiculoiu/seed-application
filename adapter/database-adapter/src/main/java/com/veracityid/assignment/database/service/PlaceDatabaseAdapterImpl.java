package com.veracityid.assignment.database.service;

import com.veracityid.assignment.database.repository.PlaceRepository;
import com.veracityid.assignment.service.adapter.database.PlaceDatabaseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceDatabaseAdapterImpl implements PlaceDatabaseAdapter {

    private final PlaceRepository placeRepository;

}
