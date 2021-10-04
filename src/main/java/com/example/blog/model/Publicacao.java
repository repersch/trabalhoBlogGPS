package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publicacao {

    @Id @GeneratedValue
    private Long idPublicacao;

    private String titulo;
    private String subtitulo;
    private String conteudo;

    public Publicacao() {
    }

    public Publicacao(Long idPublicacao, String titulo, String subtitulo, String conteudo) {
        this.idPublicacao = idPublicacao;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.conteudo = conteudo;
    }

    public Long getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Long idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
