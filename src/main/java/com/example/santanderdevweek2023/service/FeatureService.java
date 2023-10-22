package com.example.santanderdevweek2023.service;

import com.example.santanderdevweek2023.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;



}
