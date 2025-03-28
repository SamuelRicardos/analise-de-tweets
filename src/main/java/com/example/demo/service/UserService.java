package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario encontrarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
    }

    public Usuario alterarDadosUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setComentario(usuarioAtualizado.getComentario());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarDadosUsuario(Long id) {
        Usuario usuarioDeletado = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID:" + id));
        usuarioRepository.delete(usuarioDeletado);
    }
}
