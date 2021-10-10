package com.example.blog.service;

import com.example.blog.exceptions.ProjetoNaoCadastradoException;
import com.example.blog.exceptions.UsuarioNaoCadastradoException;
import com.example.blog.model.Projeto;
import com.example.blog.repository.ProjetoRepository;
import com.example.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Projeto salvarProjeto(Projeto projeto) {
        if (projeto == null) {
            throw new IllegalArgumentException("Projeto não pode ser nulo.");
        }
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetosPorUsuario(Integer idUsuario) {
        if (usuarioRepository.findById(idUsuario).isEmpty()) {
            throw new UsuarioNaoCadastradoException("Não existe usuário cadastrado com esse ID");
        }
        return projetoRepository.findAllByIdUsuario(idUsuario);
    }

    public Projeto buscarProjetoPorId(Integer idProjeto) {
        Optional<Projeto> projeto = projetoRepository.findById(idProjeto);
        if (projeto.isEmpty()) {
            throw new ProjetoNaoCadastradoException("Não existe projeto cadastrado com esse ID");
        }
        return projeto.get();
    }

    public Projeto modificarNomeProjeto(Integer idProjeto, String nome) {
        Projeto projeto = buscarProjetoPorId(idProjeto);
        projeto.setNome(nome);
        return projetoRepository.save(projeto);
    }

    public void deletarProjeto(Integer idProjeto) {
        buscarProjetoPorId(idProjeto);
        projetoRepository.deleteById(idProjeto);
    }
}
