package org.example;

/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {

    /**
     * Verifica si existe una línea con el formato exacto "usuario;clave".
     *
     * @param usuario nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @param datos objeto DatosLogin que contiene la lista de credenciales
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean autenticar(String usuario, String clave, DatosLogin datos) {
        String intento = usuario + ";" + clave;
        for (String credencial : datos.)
        // TODO: Crear String intento = usuario + ";" + clave
        // TODO: Recorrer datos.credenciales y comparar con intento
        return false;
    }
}