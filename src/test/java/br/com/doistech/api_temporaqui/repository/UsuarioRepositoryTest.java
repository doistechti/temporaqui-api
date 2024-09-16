package br.com.doistech.api_temporaqui.repository;

import br.com.doistech.api_temporaqui.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@SpringJUnitConfig
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        // Configuração inicial, se necessário
    }

    @Test
    public void testFindByUsername() {
        Usuario usuario = new Usuario();
        usuario.setUsername("testuser");
        // Defina outras propriedades se necessário
        usuarioRepository.save(usuario);

        Usuario found = usuarioRepository.findByUsername("testuser");
        assertNotNull(found);
        assertEquals("testuser", found.getUsername());
    }

    @Test
    public void testFindByUsernameNotFound() {
        Usuario found = usuarioRepository.findByUsername("nonexistentuser");
        assertNull(found);
    }
}
