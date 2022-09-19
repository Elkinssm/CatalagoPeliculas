package com.peliculas.servicio;

import com.peliculas.datos.AccesoDatosImpl;
import com.peliculas.datos.IAccesoDatos;
import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.AccesoDatosEx;
import com.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();

    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        var pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
            System.out.println("Error de acceso a datos");
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            peliculas.forEach(pelicula -> {
                System.out.println("Pelicula = " + pelicula);
            });
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
            System.out.println("Error de acceso a datos");
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso datos");
            e.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
            System.out.println("Error al iniciar catalogo de peliculas");
        }
    }
}
