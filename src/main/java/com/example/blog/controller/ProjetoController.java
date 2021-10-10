package com.example.blog.controller;

import com.example.blog.model.Projeto;
import com.example.blog.service.ProjetoService;
import com.example.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/projetos")
    public ResponseEntity<Projeto> cadastrarProjeto(@RequestBody Projeto projeto) {
        Projeto projetoSalvo = projetoService.salvarProjeto(projeto);
        if (projeto != null) {
            return ResponseEntity.ok().body(projetoSalvo);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/projetos/{idUsuario}")
    public ResponseEntity<List<Projeto>> buscarProjetosPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok().body(projetoService.listarProjetosPorUsuario(idUsuario));
    }

    @PutMapping("/projetos/{idUsuario}/{idProjeto}")
    public ResponseEntity<Projeto> editarNomeProjeto(@PathVariable Integer idUsuario, @PathVariable Integer idProjeto, @RequestBody String nome) {
        if (nome != null) {
            Projeto projetoSalvo = projetoService.modificarNomeProjeto(idProjeto, nome);
            return ResponseEntity.ok().body(projetoSalvo);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/projetos/{idUsuario}/{idProjeto}")
    public ResponseEntity<Boolean> excluirProjeto(@PathVariable Integer idUsuario, @PathVariable Integer idProjeto) {
        projetoService.deletarProjeto(idProjeto);
        return ResponseEntity.ok().build();
    }


}
