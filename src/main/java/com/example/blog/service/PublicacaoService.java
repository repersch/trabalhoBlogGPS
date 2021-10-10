package com.example.blog.service;

import com.example.blog.model.Publicacao;
import com.example.blog.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public Publicacao salvarPublicacao(Integer idProjeto, Publicacao publicacao) {
        return publicacaoRepository.save(publicacao);
    }

    public List<Publicacao> buscarPublicacoesPorProjeto(Integer idProjeto) {
        return publicacaoRepository.findAllByIdProjeto(idProjeto);
    }

    public Optional<Publicacao> buscarPublicacaoPorId(Integer idPublicacao) {
        return publicacaoRepository.findById(idPublicacao);
    }
}
