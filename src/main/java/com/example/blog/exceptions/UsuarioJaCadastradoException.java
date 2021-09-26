package com.example.blog.exceptions;

public class UsuarioJaCadastradoException extends RuntimeException {
    public UsuarioJaCadastradoException(String s) {
        System.out.println(s);
    }
}
