package com.travel.flow.external.service;


import com.travel.flow.domain.place.entity.Place;
import com.travel.flow.domain.place.repository.PlaceRepository;
import com.travel.flow.external.dto.TourApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TourApiService {
    private final PlaceRepository placeRepository;

    @Transactional
    public void syncTourData(TourApiResponse.Item item) {
        // 중복 체크 및 저장
        placeRepository.findByContentId(item.getContentid())
            .orElseGet(() -> placeRepository.save(Place.builder()
                .contentId(item.getContentid())
                .name(item.getTitle())
                .address(item.getAddr1())
                .latitude(Double.parseDouble(item.getMapy()))
                .longitude(Double.parseDouble(item.getMapx()))
                .build()));
    }
}