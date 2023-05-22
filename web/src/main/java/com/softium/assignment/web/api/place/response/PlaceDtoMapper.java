package com.softium.assignment.web.api.place.response;

import com.softium.assignment.service.core.model.MapperConstants;
import com.softium.assignment.service.core.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MapperConstants.COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaceDtoMapper {

    PlaceDto toDto(Place place);

}
