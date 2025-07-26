/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepcioness.EdadInvalidaException;
import excepcioness.NombreVacioException;
import excepcioness.NombreCortoException; 

/**
 *
 * @author sandro rendon
 */
public class Mascota {
    private String nombre;
    private int edad;

    public Mascota(String nombre, int edad) {
        // Validar nombre no vacío
        if (nombre == null || nombre.isBlank()) {
            throw new NombreVacioException("El nombre no puede estar vacío.");
        }

        // ¡NUEVA LÍNEA! Validar nombre no menor a 3 caracteres (nueva regla)
        if (nombre.length() < 3) {
            throw new NombreCortoException("El nombre no puede tener menos de 3 caracteres.");
        }

        // Validar edad no negativa 
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa.");
        }

        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println("Mascota: " + nombre + ", Edad: " + edad);
    }
}
