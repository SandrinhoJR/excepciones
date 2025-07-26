/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excepciones;

import excepcioness.EdadInvalidaException;
import excepcioness.NombreVacioException;
import excepcioness.NombreCortoException; 
import modelo.Mascota;
import java.util.Scanner;

/**
 *
 * @author sandro rendon
 */
public class Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inicio del programa...");
        Scanner scanner = new Scanner(System.in); 


        try {
            Mascota m1 = null;
            m1.mostrar(); // Esto lanza NullPointerException
        } catch (NullPointerException e) {
            System.out.println("⚠️ Error: objeto no inicializado.");
        }

   
        try {
            int edad = 10;
            int divisor = 0;
            int resultado = edad / divisor; // Error
        } catch (ArithmeticException e) {
            System.out.println("⚠️ Error aritmético: división por cero.");
        }

        try {
            Mascota m2 = new Mascota("", 5); // Nombre vacío
        } catch (NombreVacioException e) {
            System.out.println("⚠️ Excepción personalizada: " + e.getMessage());
        }

        try {
            Mascota m3 = new Mascota("Toby", -3); // Edad negativa
        } catch (EdadInvalidaException e) {
            System.out.println("⚠️ Excepción personalizada: " + e.getMessage());
        }

        String nombreMascota = "";
        int edadMascota = 0;
        boolean datosValidos = false;

        while (!datosValidos) {
            System.out.println("\nIngrese los datos de la mascota:");
            System.out.print("Nombre: ");
            nombreMascota = scanner.nextLine();

            System.out.print("Edad: ");
            try {
                edadMascota = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: La edad debe ser un número entero.");
                continue; // Volver a pedir los datos
            }

            try {
                Mascota nuevaMascota = new Mascota(nombreMascota, edadMascota);
                nuevaMascota.mostrar();
                datosValidos = true; // Los datos son válidos, salir del bucle
            } catch (NombreVacioException | EdadInvalidaException | NombreCortoException e) {
                System.out.println("⚠️ Error de validación: " + e.getMessage());
                // Los datos no son válidos, el bucle continuará
            }
        }

        scanner.close();
        System.out.println("Fin del programa.");
    }
}
