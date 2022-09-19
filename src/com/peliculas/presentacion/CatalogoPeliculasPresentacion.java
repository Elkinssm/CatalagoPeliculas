package com.peliculas.presentacion;

import com.peliculas.servicio.*;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige un aopcion : \n" + "1. Iniciar catalogo de peliculas\n" + "2. Agregar peliculas\n" + "3. LIstar peliculas\n" + "4. Buscar pelicula\n" + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> catalogo.iniciarCatalogoPeliculas();
                case 2 -> {
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                }
                case 3 -> catalogo.listarPeliculas();
                case 4 -> {
                    System.out.println("Introduce una pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                }
                case 0 -> System.out.println("Hasta Pronto!!!");
                default -> System.out.println("OPcion no reconocida");
            }
        }
    }
}
