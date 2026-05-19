package com.travel.flow.domain.itinerary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class ItineraryCreateRequest {
    private String title;
    private LocalDate startDate;
    private Integer totalDays;
    private List<Long> selectedPlaceIds; // 사용자가 카드 UI에서 선택한 장소들
}