package br.com.api.cabeleiro.autenticacao.jwt.controller;


import br.com.api.cabeleiro.ExceptionConfig.Exceptions.ConflictEmailAlreadyExist;
import br.com.api.cabeleiro.autenticacao.jwt.model.UsuarioModel;
import br.com.api.cabeleiro.autenticacao.jwt.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/userAtual")
    public ResponseEntity<UsuarioModel> UserAtual(Authentication authentication) {


        Optional<UsuarioModel> user = repository.findByEmail(authentication.getName());

        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody @Valid UsuarioModel usuario) {

        if(repository.existsByEmail(usuario.getEmail()))
            throw new ConflictEmailAlreadyExist(usuario.getEmail());



        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(repository.save(usuario));
    }



}
