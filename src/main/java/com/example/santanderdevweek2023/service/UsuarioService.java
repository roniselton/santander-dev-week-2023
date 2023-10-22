package com.example.santanderdevweek2023.service;

import com.example.santanderdevweek2023.excecoes.BusinessException;
import com.example.santanderdevweek2023.model.CartaoCredito;
import com.example.santanderdevweek2023.model.ContaBancaria;
import com.example.santanderdevweek2023.model.Usuario;
import com.example.santanderdevweek2023.model.enumerados.TipoCartao;
import com.example.santanderdevweek2023.model.enumerados.TipoConta;
import com.example.santanderdevweek2023.model.enumerados.TipoRole;
import com.example.santanderdevweek2023.repository.UsuarioRepository;
import com.example.santanderdevweek2023.util.Util;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final FeatureService featureService;

    public UsuarioService(UsuarioRepository usuarioRepository, FeatureService featureService) {
        this.usuarioRepository = usuarioRepository;
        this.featureService = featureService;
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById( id ).orElseThrow(NoSuchElementException::new);
    }

    public List<Usuario> listAll(){
        return usuarioRepository.findAll();
    }

    public void createUsuario(Usuario usuario) throws BusinessException {
        validarUsuario(usuario);
        usuario.setContas(Stream.of(ContaBancaria.builder()
                        .tipoConta(TipoConta.INDIVIDUAL)
                        .agencia("1213-5")
                        .numeroConta(Util.gerarProximoNumeroConta())
                        .saldo(BigDecimal.ZERO)
                        .limite(BigDecimal.valueOf(1000))
                        .build())
                .collect(Collectors.toList()) );
        usuario.setCartoesCredito(Stream.of(CartaoCredito.builder()
                        .tipoCartao(TipoCartao.FISICO)
                        .bandeira("Mastercar")
                        .numero(Util.gerarProximoNumeroCartao())
                        .limite(BigDecimal.valueOf(5000))
                        .build())
                .collect(Collectors.toList()) );
        usuario.setFeatures( featureService.listByRole(TipoRole.CLIENTE) );

        usuarioRepository.save(usuario);
    }


    private void validarUsuario(Usuario usuario) throws BusinessException {
        if(usuario.getId() != null)
            throw new IllegalArgumentException("ID não deve ser informado.");

        if(usuario.getNome() == null)
            throw new BusinessException("Nome é obrigatório!");
    }


}
