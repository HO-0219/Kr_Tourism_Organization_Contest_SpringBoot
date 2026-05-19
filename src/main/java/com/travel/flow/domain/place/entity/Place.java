package com.travel.flow.domain.place.entity;

import com.travel.flow.domain.common.BaseTimeEntity;
import com.travel.flow.domain.category.Category;
import com.travel.flow.domain.region.Region;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Table(name = "place")
@Getter @Builder @AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long contentId; // TourAPI 고유 번호

    private String name;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "region_id")
    private Region region;
    private String address;
    private Double latitude;
    private Double longitude;
    @Lob private String description;
    @Builder.Default private Integer viewCount = 0;
    @Builder.Default private Boolean isActive = true;
}