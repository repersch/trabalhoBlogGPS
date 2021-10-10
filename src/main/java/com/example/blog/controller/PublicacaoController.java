package com.example.blog.controller;

import com.example.blog.model.Projeto;
import com.example.blog.model.Publicacao;
import com.example.blog.service.ProjetoService;
import com.example.blog.service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class PublicacaoController {

    @Autowired
    private PublicacaoService publicacaoService;

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/projetos/{idUsuario}/{idProjeto}/publicacao")
    public ResponseEntity<Publicacao> cadastrarPublicacao(@PathVariable Integer idUsuario, @PathVariable Integer idProjeto, @RequestBody Publicacao publicacao) {
        Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
        publicacao.setIdProjeto(idProjeto);

        Publicacao publicacaoSalva = publicacaoService.salvarPublicacao(idProjeto, publicacao);
        return ResponseEntity.ok().body(publicacaoSalva);
    }

    @GetMapping("/projetos/{idUsuario}/{idProjeto}/publicacao")
    public ResponseEntity<List<Publicacao>> listarPublicacoes(@PathVariable Integer idProjeto) {

       if (projetoService.buscarProjetoPorId(idProjeto) != null) {
           List<Publicacao> publicacoes = publicacaoService.buscarPublicacoesPorProjeto(idProjeto);
           return ResponseEntity.ok().body(publicacoes);
       }
       return ResponseEntity.badRequest().build();
    }

    @GetMapping("/projetos/{idUsuario}/{idProjeto}/{idPublicacao}")
    public ResponseEntity<Publicacao> listarPublicacaoPorId(@PathVariable Integer idPublicacao) {
        Optional<Publicacao> publicacao = publicacaoService.buscarPublicacaoPorId(idPublicacao);

        return publicacao.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.badRequest().build());
    }





}
