package com.example.blog.controller;

import com.example.blog.model.Usuario;
import com.example.blog.model.dto.UsuarioRequestDTO;
import com.example.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok().body(usuarioSalvo);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> buscarUsuarios() {
        return ResponseEntity.ok().body(usuarioService.listarUsuarios());
    }

    @GetMapping("/usuarios/{idUsuario}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long idUsuario) {
        Optional<Usuario> usuario = usuarioService.listarUsuarioPorId(idUsuario);
        return usuario.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @PostMapping("/auth")
    public ResponseEntity<String> autenticar(@RequestBody UsuarioRequestDTO usuario) {
        boolean autenticado = usuarioService.login(usuario);
        if (autenticado) {
            return ResponseEntity.ok("Usuário autenticado com sucesso.");
        }
        return ResponseEntity.badRequest().body("E-mail e/ou senha inválidos");
    }

}
