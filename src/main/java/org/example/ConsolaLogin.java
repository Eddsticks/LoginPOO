package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    static Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        }
        while (opcion != 2);
        // TODO: Implementar ciclo del menú principal
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        System.out.println("=== INICIO DE SESIÓN ===");
        System.out.println("1. Iniciar Sesión.\n2. Salir.\n");
        // TODO: Mostrar "1. Iniciar sesión", "2. Salir"
    }

    /**
     * Analiza la entrada proporcionada por el usuario.
     * @return opción elegida.
     */
    private static int obtenerOpcion() {
        while (true) {
            System.out.println("Ingrese una opción: ");
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                if (opcion == 1 || opcion == 2) {
                    return opcion;
                } else {
                    System.out.println("Ingrese 1 ó 2.");
                }
            } else {
                System.out.println("Entrada no válida.");
                scanner.next();
            }
        }
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> manejarLogin();
            case 2 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no reconocida.");
        }
        // TODO: Si es "1" llamar a manejarLogin, si es "2" salir
    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private void manejarLogin() {
        int intentos = 3;
        scanner.nextLine();

        while (intentos > 0) {
            System.out.println("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Clave: ");
            String clave = scanner.nextLine();

            if (login.autenticar(usuario, clave, datos)) {
                System.out.println("Inicio de sesión exitoso.");
                return;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }
        System.out.println("Demasiados intentos fallidos. Volviendo a inicio...\n");
        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
    }
}