package com.example.santanderdevweek2023.repository;

import com.example.santanderdevweek2023.model.Features;
import com.example.santanderdevweek2023.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Features, Long> {
}
