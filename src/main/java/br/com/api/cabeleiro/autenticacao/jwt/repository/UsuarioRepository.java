package br.com.api.cabeleiro.autenticacao.jwt.repository;



import br.com.api.cabeleiro.autenticacao.jwt.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    Optional<UsuarioModel> findByEmail(String login);
    @Query("SELECT email FROM Usuario u WHERE u.email = :email")
    String existsEmail(@Param("email") String email);



}
