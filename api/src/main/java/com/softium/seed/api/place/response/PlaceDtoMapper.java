package com.softium.seed.api.place.response;

import com.softium.seed.domain.core.model.MapperConstants;
import com.softium.seed.domain.core.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MapperConstants.COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaceDtoMapper {

    PlaceDto toDto(Place place);

}
