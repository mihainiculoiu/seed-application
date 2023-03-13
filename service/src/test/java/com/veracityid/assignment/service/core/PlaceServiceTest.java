package com.veracityid.assignment.service.core;

import com.veracityid.assignment.service.adapter.database.PlaceDatabaseAdapter;
import com.veracityid.assignment.service.core.service.PlaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlaceServiceTest {

    private PlaceService placeService;

    @Mock
    private PlaceDatabaseAdapter placeDatabaseAdapter;

    @BeforeEach
    void setUp() {
        placeService = new PlaceService(placeDatabaseAdapter);
    }

}
