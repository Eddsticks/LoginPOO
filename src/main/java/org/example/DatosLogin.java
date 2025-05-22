package org.example;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        cargarUsuarios();
    }

    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de credenciales.
     */
    private void cargarUsuarios() {
        String nombreArchivo = "src/LoginData/login.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty() && linea.contains(";")) {
                    credenciales.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        // TODO: Abrir archivo login.txt
        // TODO: Leer línea por línea y agregar solo las que contienen ";"
        // TODO: Ignorar líneas vacías o mal formateadas
    }

    public ArrayList<String> getCredenciales() {
        return credenciales;
    }
}