package com.softium.seed.api.place;

import com.softium.seed.api.place.response.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1/places")
@RequiredArgsConstructor
public class PlaceController implements PlaceControllerApi {

    private final PlaceFacade placeFacade;

    @Override
    @GetMapping(value = "/{placeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDto> getPlace(@PathVariable String placeId) {
        return new ResponseEntity<>(placeFacade.getPlaceById(placeId), OK);
    }

}
