package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "publicacao")
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacao")
    private Integer idPublicacao;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "subtitulo")
    private String subtitulo;

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "id_projeto")
    private Integer idProjeto;

    public Publicacao() {
    }

    public Publicacao(String titulo, String subtitulo, String conteudo) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.conteudo = conteudo;
    }

    public Integer getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Integer idPublicacao) {
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

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }
}
