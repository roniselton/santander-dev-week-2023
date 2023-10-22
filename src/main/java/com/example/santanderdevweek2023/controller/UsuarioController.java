package com.example.santanderdevweek2023.controller;

import com.example.santanderdevweek2023.excecoes.BusinessException;
import com.example.santanderdevweek2023.model.Usuario;
import com.example.santanderdevweek2023.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public List<Usuario> listarUsuarios(){
        return usuarioService.listAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> detalharUsuario(@PathVariable("idUsuario") Long idUsuario){
        var usuario = usuarioService.findById( idUsuario ) ;
        return ResponseEntity.ok( usuario );
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Long> excluirUsuario(@PathVariable("idUsuario") Long idUsuario){
        usuarioService.excluir(idUsuario) ;
        return ResponseEntity.ok(idUsuario);
    }

    @PostMapping()
    public ResponseEntity<Usuario> incluirUsuario(@RequestBody Usuario usuario){
            usuarioService.createUsuario(usuario);
            return ResponseEntity.ok( usuario );
    }

//    @PutMapping()
//    public void alterarUsuario(@RequestBody Usuario usuario){
//        try {
//            usuarioService.alterar(usuario);
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
//    }
}
