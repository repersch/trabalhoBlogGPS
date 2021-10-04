package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projeto {

    @Id @GeneratedValue
    private Long idProjeto;

    private String nome;
    private Long idUsuario;

    private static List<Publicacao> listaPublicacoes = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(String nome, Long idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
    }

    public boolean adicionaPublicacao(Publicacao publicacao) {
        return listaPublicacoes.add(publicacao);
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static List<Publicacao> getListaPublicacoes() {
        return listaPublicacoes;
    }

    public static void setListaPublicacoes(List<Publicacao> listaPublicacoes) {
        Projeto.listaPublicacoes = listaPublicacoes;
    }
}
