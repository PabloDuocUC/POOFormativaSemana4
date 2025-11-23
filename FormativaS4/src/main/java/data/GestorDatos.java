package data;

import model.CentroDeProduccion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    public List<CentroDeProduccion> leerCentros(String rutaArchivo) {
        List<CentroDeProduccion> listaCentros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Si linea esta vacia
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(";");
                // Si el formato es incorrecto
                if (datos.length != 3) {
                    System.err.println("Línea con formato incorrecto: " + linea); //imprime numero de linea
                    continue;
                }

                String nombre = datos[0].trim();
                String comuna = datos[1].trim();
                double toneladas = Double.parseDouble(datos[2].trim());

                listaCentros.add(new CentroDeProduccion(nombre, comuna, toneladas));
            }
        } catch (IOException e) {

            System.err.println("Error al leer el archivo: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.err.println("Formato númerico incorrecto: " + e.getMessage());
        }

        return listaCentros;
    }
}
