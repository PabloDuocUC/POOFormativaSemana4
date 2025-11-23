package model;

public class CentroDeProduccion {

    private String nombre;
    private String comuna;
    private double toneladasProducidas;

    public CentroDeProduccion(String nombre, String comuna, double toneladasProducidas) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.toneladasProducidas = toneladasProducidas;
    }

    public double getToneladasProducidas() {
        return toneladasProducidas;
    }

    public String getComuna() {
        return comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setToneladasProducidas(double toneladasProducidas) {
        this.toneladasProducidas = toneladasProducidas;
    }

    @Override
    public String toString() {
        return "CentroDeCultivo{" +
                "nombre='" + nombre + '\'' +
                ", comuna='" + comuna + '\'' +
                ", pesoProducido=" + toneladasProducidas +
                '}';
    }
}
