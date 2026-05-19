package com.travel.flow.domain.itinerary.entity;

import com.travel.flow.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "itinerary")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Itinerary extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate startDate;

    private Integer totalDays;

    @Column(unique = true, nullable = false)
    private String shareToken;

    @Builder.Default
    private Boolean isPublic = true;

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("dayNumber ASC, orderIndex ASC")
    @Builder.Default
    private List<ItineraryItem> items = new ArrayList<>();

    @PrePersist
    public void createToken() {
        this.shareToken = UUID.randomUUID().toString().substring(0, 8);
    }
}