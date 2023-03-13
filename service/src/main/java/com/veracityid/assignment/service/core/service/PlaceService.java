package com.veracityid.assignment.service.core.service;

import com.veracityid.assignment.service.adapter.database.PlaceDatabaseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService {

    private final PlaceDatabaseAdapter placeDatabaseAdapter;

}
