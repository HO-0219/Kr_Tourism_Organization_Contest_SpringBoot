package com.travel.flow.domain.place.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import com.travel.flow.domain.place.entity.Place;


import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "place_accessibility")
@Getter @Builder @AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceAccessibility {
    @Id private Long placeId;
    @MapsId @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "place_id")
    private Place place;
    @Enumerated(EnumType.STRING) private Level walkingLevel;
    @Enumerated(EnumType.STRING) private Level slopeLevel;
    private Boolean hasStairs;
    private Boolean hasRestroom;
    private Boolean isIndoor;
    public enum Level { LOW, MEDIUM, HIGH }
}