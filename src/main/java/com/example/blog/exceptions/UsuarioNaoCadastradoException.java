package com.example.blog.exceptions;

public class UsuarioNaoCadastradoException extends RuntimeException {
    public UsuarioNaoCadastradoException(String s) {
        System.out.println(s);
    }
}
