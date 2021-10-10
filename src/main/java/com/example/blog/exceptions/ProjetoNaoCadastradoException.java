package com.example.blog.exceptions;

public class ProjetoNaoCadastradoException extends RuntimeException {

    public ProjetoNaoCadastradoException(String s) {
        System.out.println(s);
    }

}
