package ui;

import data.GestorDatos;
import model.CentroDeProduccion;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();

        String rutaArchivo = "src/main/resources/centrosDeProduccion.txt";
        //Se cargan los centros
        List<CentroDeProduccion> listaCentros = gestor.leerCentros(rutaArchivo);

        //Se valida una correcta carga de los centros
        if (listaCentros.isEmpty()) {
            System.out.println("No se pudieron cargar centros. Verifica el archivo.");
            return;
        }

        //Recorrido del archivo almacenado en una lista
        System.out.println("Lista de todos los centros de produccion: ");
        for (CentroDeProduccion centro : listaCentros) {
            System.out.println(centro); //Imprimimos datos de los objetos gracias a ToString
        }

        //Filtro de centros con más de 1000kg de produccion
        System.out.println("Lista de centros de produccion con más de 1 tonelada en almacen: ");

        double filtroProduccion = 1000;

        for (CentroDeProduccion centro : listaCentros) {
            if (centro.getToneladasProducidas() > filtroProduccion) {
                System.out.println(centro);
            }
        }

        //Una busqueda para filtrar por nombres de los lugares de centro de produccion
        System.out.println("Buscar centro de produccion: ");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese comuna: ");
        String comunaBuscada = scanner.nextLine();

        for (CentroDeProduccion centro : listaCentros) {
            if (centro.getComuna().equalsIgnoreCase(comunaBuscada)) {
                System.out.println("Islas Encontrada en" + comunaBuscada +": " + centro.getNombre());
            }
        }
        scanner.close();
    }
}