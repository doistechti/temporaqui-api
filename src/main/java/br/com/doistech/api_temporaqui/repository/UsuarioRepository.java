package br.com.doistech.api_temporaqui.repository;


import br.com.doistech.api_temporaqui.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
