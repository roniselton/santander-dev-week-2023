package com.example.santanderdevweek2023.service;

import com.example.santanderdevweek2023.model.Feature;
import com.example.santanderdevweek2023.model.enumerados.TipoRole;
import com.example.santanderdevweek2023.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public List<Feature> listByRole(TipoRole role){
        return featureRepository.findAll();
    }
}
