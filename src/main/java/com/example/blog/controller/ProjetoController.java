package com.example.blog.controller;

import com.example.blog.model.Projeto;
import com.example.blog.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/projetos/{idUsuario}")
    public ResponseEntity<Projeto> cadastrarProjeto(@PathVariable Long idUsuario, @RequestBody String nomeProjeto) {
        Projeto projeto = new Projeto(nomeProjeto, idUsuario);
        return ResponseEntity.ok().body(projeto);
    }

    @GetMapping("/projetos/{idUsuario}")
    public ResponseEntity<List<Projeto>> buscarProjetosPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok().body(projetoService.listarProjetosPorUsuario(idUsuario));
    }

}
