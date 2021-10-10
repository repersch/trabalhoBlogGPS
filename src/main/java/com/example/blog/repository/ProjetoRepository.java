package com.example.blog.repository;

import com.example.blog.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    List<Projeto> findAllByIdUsuario(Integer idUsuario);



}
