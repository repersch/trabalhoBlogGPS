package com.example.blog.repository;

import com.example.blog.model.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

    List<Publicacao> findAllByIdProjeto(Integer idProjeto);
}
