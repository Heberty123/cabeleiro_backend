package br.com.api.cabeleiro.autenticacao.jwt.services;


import br.com.api.cabeleiro.autenticacao.jwt.data.DetalheUsuarioData;
import br.com.api.cabeleiro.autenticacao.jwt.model.UsuarioModel;
import br.com.api.cabeleiro.autenticacao.jwt.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsuarioModel> usuario = repository.findByLogin(username);
        if(usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario [" + username + "] não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }
}
