package com.travel.flow.external.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Table(name = "raw_tour_api")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RawTourApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long contentId;

    private String apiType;

    @Lob
    private String rawJson;

    private LocalDateTime fetchedAt;
}
