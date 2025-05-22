package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

class LoginTest {
    @Test
    void loginValido() {
        DatosLogin datos = new DatosLogin();
        datos.getCredenciales().clear();
        datos.getCredenciales().add("user1;password123");
        datos.getCredenciales().add("user2;abc123");

        Login login = new Login();

        assertTrue(login.autenticar("user1", "password123", datos));
    }

    @Test
    void usuarioInexistente() {
        DatosLogin datos = new DatosLogin();
        datos.getCredenciales().clear();
        datos.getCredenciales().add("user1;password123");

        Login login = new Login();

        assertFalse(login.autenticar("usuarioNoExiste", "password123", datos));
    }

    @Test
    void contraseñaIncorrecta() {
        DatosLogin datos = new DatosLogin();
        datos.getCredenciales().clear();
        datos.getCredenciales().add("user1;password123");

        Login login = new Login();

        assertFalse(login.autenticar("user1", "claveErronea", datos));
    }

    // Caso 4: archivo no encontrado - verificar que se maneje la excepción
    @Test
    void archivoNoEncontrado() throws IOException {
        // Renombrar o mover temporalmente el archivo original si existe
        Path originalPath = Path.of("src/LoginData/login.txt");
        Path tempPath = Path.of("src/LoginData/login_backup.txt");

        boolean originalExists = Files.exists(originalPath);

        if (originalExists) {
            Files.move(originalPath, tempPath);
        }

        try {
            DatosLogin datos = new DatosLogin();
            // Como el archivo no existe, credenciales debería estar vacía
            assertTrue(datos.getCredenciales().isEmpty(), "Lista debe estar vacía si no hay archivo");
        } finally {
            // Restaurar archivo
            if (originalExists) {
                Files.move(tempPath, originalPath);
            }
        }
    }
}