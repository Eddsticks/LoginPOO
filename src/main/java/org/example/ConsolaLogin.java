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
        System.out.println("1. Iniciar Sesión.\n 2. Salir.\n");
        // TODO: Mostrar "1. Iniciar sesión", "2. Salir"
    }

    /**
     * Analiza la entrada proporcionada por el usuario.
     * @return
     */
    private static int obtenerOpcion() {
        ArrayList<Integer> validOp = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            validOp.add(i);
        }
        Scanner entrada = new Scanner(System.in);
        while (true) {
            boolean isInt = scanner.hasNextInt();
            if (isInt) {
                int opcion = scanner.nextInt();
                if (validOp.contains(opcion)) {
                    return opcion;
                } else {
                    System.out.println("Ingrese un valor entre 1 y 2.");
                }
            } else {
                System.out.println("Ingrese un valor entero.");
            }
            scanner.nextLine();
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
        System.out.println("Prueba de funcionamiento");
        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
    }
}