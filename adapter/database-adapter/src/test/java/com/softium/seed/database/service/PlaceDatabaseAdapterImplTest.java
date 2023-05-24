package com.softium.seed.database.service;

import com.softium.seed.database.repository.PlaceRepository;
import com.softium.seed.database.repository.mapper.EntityIdMapper;
import com.softium.seed.database.repository.mapper.PlaceEntityMapper;
import com.softium.seed.database.repository.mapper.PlaceEntityMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PlaceDatabaseAdapterImplTest {

    private PlaceDatabaseAdapterImpl placeDatabaseAdapter;

    private final EntityIdMapper entityIdMapper = Mappers.getMapper(EntityIdMapper.class);

    @Mock
    private PlaceRepository placeRepository;

    @BeforeEach
    void setUp() {
        PlaceEntityMapper placeEntityMapper = new PlaceEntityMapperImpl(entityIdMapper);

        placeDatabaseAdapter = new PlaceDatabaseAdapterImpl(
                placeRepository,
                placeEntityMapper);
    }

    @Test
    void test() {
        assertThat("ceva").isNotNull();
    }

}
