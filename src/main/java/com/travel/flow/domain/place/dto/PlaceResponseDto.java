package com.travel.flow.domain.place.dto;

import lombok.*;



@Getter @AllArgsConstructor
public class PlaceResponseDto {
    private Long id;
    private String name;
    private String address;
}