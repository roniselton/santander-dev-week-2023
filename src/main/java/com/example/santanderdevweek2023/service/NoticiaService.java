package com.example.santanderdevweek2023.service;

import com.example.santanderdevweek2023.repository.NoticiaRepository;
import com.example.santanderdevweek2023.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }
}
