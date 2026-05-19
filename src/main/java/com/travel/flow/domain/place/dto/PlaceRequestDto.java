package com.travel.flow.domain.place.dto;

import lombok.*;

public class PlaceRequestDto {
    @Getter @NoArgsConstructor
    public static class Create {
        private String name;
        private String address;
    }
}