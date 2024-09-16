package br.com.doistech.api_temporaqui.controller;

import br.com.doistech.api_temporaqui.service.UsuarioService;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void testGetUsuario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetUsuarioHeaders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/testuser"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.header().exists("Content-Type"))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"));
    }

    @Test
    public void testGetUsuarioWithQueryParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios")
                        .param("username", "testuser"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testuser"));
    }

//    @Test
//    public void testGetUsuario() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/testuser"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testuser"));
//    }

    @Test
    public void testCreateUsuario() throws Exception {
        String usuarioJson = "{\"username\":\"newuser\", \"password\":\"password123\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuarioJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("newuser"));
    }

    @Test
    public void testCreateUsuarioInvalidData() throws Exception {
        String invalidUsuarioJson = "{\"username\":\"\", \"password\":\"\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidUsuarioJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetUsuarioUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/testuser"))
                .andExpect(status().isUnauthorized());
    }


}
