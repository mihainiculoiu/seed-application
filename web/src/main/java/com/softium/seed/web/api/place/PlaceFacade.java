package com.softium.seed.web.api.place;

import com.softium.seed.domain.core.model.Place;
import com.softium.seed.domain.core.service.PlaceService;
import com.softium.seed.web.api.place.response.PlaceDto;
import com.softium.seed.web.api.place.response.PlaceDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceFacade {

    private final PlaceService placeService;
    private final PlaceDtoMapper placeDtoMapper;

    public PlaceDto getPlaceById(String placeId) {
        Place place = placeService.getPlaceById(placeId);

        return placeDtoMapper.toDto(place);
    }

}
