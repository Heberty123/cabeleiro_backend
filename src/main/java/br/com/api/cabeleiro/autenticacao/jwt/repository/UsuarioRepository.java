package br.com.api.cabeleiro.autenticacao.jwt.repository;



import br.com.api.cabeleiro.autenticacao.jwt.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    public Optional<UsuarioModel> findByLogin(String login);

}
