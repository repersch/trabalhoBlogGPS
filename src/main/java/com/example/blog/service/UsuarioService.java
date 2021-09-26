package com.example.blog.service;

import com.example.blog.exceptions.UsuarioJaCadastradoException;
import com.example.blog.exceptions.UsuarioNaoCadastradoException;
import com.example.blog.model.Usuario;
import com.example.blog.model.dto.UsuarioRequestDTO;
import com.example.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        if(repository.findByEmail(usuario.getEmail()) != null) {
            throw new UsuarioJaCadastradoException("E-mail já cadastrado");
        }
        return repository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Optional<Usuario> listarUsuarioPorId(Long idUsuario) {
        return repository.findById(idUsuario);

    }

    public boolean login(UsuarioRequestDTO usuario) {
        Usuario usuarioBanco = repository.findByEmail(usuario.getEmail());
        if (usuarioBanco != null) {
            return usuarioBanco.getEmail().equals(usuario.getEmail()) &&
                    usuarioBanco.getSenha().equals(usuario.getSenha());
        }
        throw new UsuarioNaoCadastradoException("Não existe usuário cadastrado com esse e-mail");
    }
}
