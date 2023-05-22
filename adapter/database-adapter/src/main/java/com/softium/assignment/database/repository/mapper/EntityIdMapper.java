package com.softium.assignment.database.repository.mapper;

import com.softium.assignment.service.core.model.MapperConstants;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(componentModel = MapperConstants.COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityIdMapper {

    default UUID map(String value) {
        return value != null ? UUID.fromString(value): null;
    }

    default String map(UUID value) {
        return value != null ? value.toString() : null;
    }

}
