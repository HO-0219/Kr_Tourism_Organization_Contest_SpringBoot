package com.travel.flow.domain.place.service;


import com.travel.flow.domain.place.dto.PlaceResponseDto;
import com.travel.flow.domain.place.entity.Place;
import com.travel.flow.domain.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceService {
    private final PlaceRepository placeRepository;

    public List<PlaceResponseDto> findAll() {
        return placeRepository.findAll().stream()
            .map(p -> new PlaceResponseDto(p.getId(), p.getName(), p.getAddress()))
            .toList();
    }
}