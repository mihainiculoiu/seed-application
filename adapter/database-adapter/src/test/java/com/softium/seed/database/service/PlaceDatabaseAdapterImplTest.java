package com.softium.seed.database.service;

import com.softium.seed.database.entity.PlaceEntityMother;
import com.softium.seed.database.repository.PlaceRepository;
import com.softium.seed.database.repository.mapper.EntityIdMapper;
import com.softium.seed.database.repository.mapper.PlaceEntityMapper;
import com.softium.seed.database.repository.mapper.PlaceEntityMapperImpl;
import com.softium.seed.domain.core.PlaceMother;
import com.softium.seed.domain.core.exception.ResourceNotFoundException;
import com.softium.seed.domain.core.model.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static com.softium.seed.database.service.PlaceDatabaseAdapterImpl.PLACE_NOT_FOUND_BY_ID_ERROR_MESSAGE;
import static com.softium.seed.domain.core.PlaceConstants.PLACE_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

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
    void returnPlaceWhenGetPlaceById() {
        given(placeRepository.findById(UUID.fromString(PLACE_ID)))
                .willReturn(Optional.of(PlaceEntityMother.completePlaceEntity()));

        Place place = placeDatabaseAdapter.getPlaceById(PLACE_ID);

        assertThat(place).isEqualTo(PlaceMother.complete());
    }

    @Test
    void throwResourceNotFoundExceptionWhenGetPlaceById() {
        given(placeRepository.findById(UUID.fromString(PLACE_ID)))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> placeDatabaseAdapter.getPlaceById(PLACE_ID))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format(PLACE_NOT_FOUND_BY_ID_ERROR_MESSAGE, PLACE_ID));
    }

}
