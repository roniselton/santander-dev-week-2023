package com.example.santanderdevweek2023.service;

import com.example.santanderdevweek2023.repository.NoticiaRepository;
import com.example.santanderdevweek2023.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;



}
