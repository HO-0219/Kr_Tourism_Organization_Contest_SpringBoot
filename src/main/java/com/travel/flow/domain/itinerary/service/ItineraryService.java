package com.travel.flow.domain.itinerary.service;

import com.travel.flow.domain.itinerary.dto.ItineraryCreateRequest;
import com.travel.flow.domain.itinerary.entity.Itinerary;
import com.travel.flow.domain.itinerary.entity.ItineraryItem;
import com.travel.flow.domain.itinerary.repository.ItineraryRepository;
import com.travel.flow.domain.place.entity.Place;
import com.travel.flow.domain.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final PlaceRepository placeRepository;

    @Transactional
    public Long createAutomaticItinerary(ItineraryCreateRequest request) {
        // 1. 기본 정보 생성
        Itinerary itinerary = Itinerary.builder()
                .title(request.getTitle())
                .startDate(request.getStartDate())
                .totalDays(request.getTotalDays())
                .build();

        // 2. 선택된 장소들 조회
        List<Place> selectedPlaces = placeRepository.findAllById(request.getSelectedPlaceIds());

        // 3. 자동 코스 생성 로직 (단순화: 거리순 정렬 및 Day 분배)
        // 실제 운영시는 Nearest Neighbor 알고리즘 적용 구간
        for (int i = 0; i < selectedPlaces.size(); i++) {
            int dayNumber = (i / 3) + 1; // 예: 하루에 3곳씩 배분
            if (dayNumber > request.getTotalDays()) dayNumber = request.getTotalDays();

            ItineraryItem item = ItineraryItem.builder()
                    .itinerary(itinerary)
                    .place(selectedPlaces.get(i))
                    .dayNumber(dayNumber)
                    .orderIndex(i % 3)
                    .stayMinutes(90) // 기본 1시간 30분 체류
                    .build();
            
            itinerary.getItems().add(item);
        }

        return itineraryRepository.save(itinerary).getId();
    }
}