package com.veracityid.assignment.database.repository.mapper;

import com.veracityid.assignment.database.entity.PlaceEntity;
import com.veracityid.assignment.service.core.model.MapperConstants;
import com.veracityid.assignment.service.core.model.Place;
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
