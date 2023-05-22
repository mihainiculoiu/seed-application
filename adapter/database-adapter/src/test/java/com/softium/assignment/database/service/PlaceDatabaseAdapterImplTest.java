package com.softium.assignment.database.service;

import com.softium.assignment.database.repository.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PlaceDatabaseAdapterImplTest {

    private PlaceDatabaseAdapterImpl placeDatabaseAdapter;

    @Mock
    private PlaceRepository placeRepository;

    @BeforeEach
    void setUp() {
        placeDatabaseAdapter = new PlaceDatabaseAdapterImpl(placeRepository);
    }

    @Test
    void test() {
        assertThat("ceva").isNotNull();
    }

}
