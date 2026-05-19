package com.travel.flow.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.flow.domain.place.entity.Place;

import java.util.Optional;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByContentId(Long contentId);
    
} 