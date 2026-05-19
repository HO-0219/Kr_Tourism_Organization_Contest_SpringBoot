package com.travel.flow.domain.place.controller;

import com.travel.flow.domain.place.dto.PlaceResponseDto;
import com.travel.flow.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping
    public List<PlaceResponseDto> getPlaces() {
        return placeService.findAll();
    }
}