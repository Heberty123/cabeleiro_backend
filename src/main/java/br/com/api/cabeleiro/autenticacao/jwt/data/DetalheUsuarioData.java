package br.com.api.cabeleiro.autenticacao.jwt.data;

import br.com.api.cabeleiro.autenticacao.jwt.model.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheUsuarioData implements UserDetails {

    private final Optional<UsuarioModel> usuario;

    public DetalheUsuarioData(Optional<UsuarioModel> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new UsuarioModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new UsuarioModel()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuario.orElse(new UsuarioModel()).isEnable();
    }
}
