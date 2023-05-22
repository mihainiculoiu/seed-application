package com.softium.assignment.web.api.place;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController implements PlaceControllerApi {

    private final PlaceFacade placeFacade;

}
