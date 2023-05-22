package com.softium.seed.database.repository.mapper;

import com.softium.seed.database.entity.PlaceEntity;
import com.softium.seed.domain.core.model.MapperConstants;
import com.softium.seed.domain.core.model.Place;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MapperConstants.COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                EntityIdMapper.class
        })
public interface PlaceEntityMapper {

    PlaceEntity toEntity(Place place);

    Place toDomain(PlaceEntity placeEntity);

}
