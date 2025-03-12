package org.example;

public class Llamada {

    private static final double TARIFA_LOCAL = 50.0;
    private static final double TARIFA_LARGA_DISTANCIA = 350.0;
    private static final double TARIFA_CELULAR = 150.0;

    String tipo;
    int numeroLlamadas;
    int duracionTotal;
    double costoTotal;

    public Llamada() {
        this.tipo = "Local";
        this.numeroLlamadas = 0;
        this.duracionTotal = 0;
        this.costoTotal = 0.0;
    }

    public void registrarLlamada(int duracion) {
        this.numeroLlamadas++;
        this.duracionTotal += duracion;

        switch (this.tipo) {
            case "Local":
                this.costoTotal += duracion * TARIFA_LOCAL;
                break;
            case "Larga Distancia":
                this.costoTotal += duracion * TARIFA_LARGA_DISTANCIA;
                break;
            case "Celular":
                this.costoTotal += duracion * TARIFA_CELULAR;
                break;
        }
    }

    public void reiniciarCabina() {
        this.numeroLlamadas = 0;
        this.duracionTotal = 0;
        this.costoTotal = 0.0;
    }

    public void mostrarInformacion() {
        System.out.println("Cabina tipo: " + tipo);
        System.out.println("Número de llamadas: " + numeroLlamadas);
        System.out.println("Duración total de las llamadas: " + duracionTotal + " minutos");
        System.out.println("Costo total: $" + costoTotal);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
