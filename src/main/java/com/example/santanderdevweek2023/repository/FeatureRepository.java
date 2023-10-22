package com.example.santanderdevweek2023.repository;

import com.example.santanderdevweek2023.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
