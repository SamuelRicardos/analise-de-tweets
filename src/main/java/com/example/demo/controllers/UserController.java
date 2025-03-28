package com.example.demo.controllers;

import com.example.demo.model.Usuario;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Usuario> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid Usuario usuario) {
        Usuario novoUsuario = userService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> encontrarUsuarioPorId(@PathVariable("id") Long id) {
        Usuario usuario = userService.encontrarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> alterarDadosUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Usuario usuarioAlterado = userService.alterarDadosUsuario(id, usuario);
        return new ResponseEntity<>(usuarioAlterado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable("id") Long id) {
        userService.deletarDadosUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
