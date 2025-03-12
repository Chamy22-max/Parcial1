package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Llamada> cabinas = new ArrayList<>();
        Random random = new Random();

        /*https://docs.oracle.com/javase/8/docs/api/java/util/Random.html*/
        while (true) {
            System.out.println("\033[0;3m" + "Seleccione lo que desea realizar:" + "\033[0m");
            System.out.println("1. Crear Cabinas 🏠");
            System.out.println("2. Escoger Cabina y Hacer Llamada 📲");
            System.out.println("3. Mostrar Información por Cabina");
            System.out.println("4. Mostrar información de todas las cabinas 🏘️");
            System.out.println("5. Reiniciar Cabina");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de cabinas a crear: ");
                    int cantidadCabinas = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < cantidadCabinas; i++) {
                        cabinas.add(new Llamada());
                    }
                    System.out.println(cantidadCabinas + " cabinas creadas.");
                    break;

                case 2:
                    if (cabinas.isEmpty()) {
                        System.out.println("No hay cabinas disponibles. Primero debe crear cabinas.");
                        break;
                    }

                    System.out.println("Seleccione la cabina:");
                    for (int i = 0; i < cabinas.size(); i++) {
                        System.out.println(i + 1 + ". Cabina " + (i + 1));
                    }

                    int seleccionCabina = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (seleccionCabina >= 0 && seleccionCabina < cabinas.size()) {
                        Llamada cabinaSeleccionada = cabinas.get(seleccionCabina);
                        System.out.println("Cabina seleccionada: Cabina " + (seleccionCabina + 1));

                        System.out.println("Seleccione el tipo de llamada:");
                        System.out.println("1. Local");
                        System.out.println("2. Larga Distancia");
                        System.out.println("3. Celular");
                        int tipoLlamada = scanner.nextInt();
                        scanner.nextLine();

                        String tipo = "";
                        switch (tipoLlamada) {
                            case 1:
                                tipo = "Local";
                                break;
                            case 2:
                                tipo = "Larga Distancia";
                                break;
                            case 3:
                                tipo = "Celular";
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                continue;
                        }

                        cabinaSeleccionada.setTipo(tipo);

                        /*https://es.stackoverflow.com/questions/5390/como-generar-n%C3%BAmeros-aleatorios-dentro-de-un-rango-de-valores*/
                        int duracion = random.nextInt(10) + 1;
                        System.out.println("Duración de la llamada: " + duracion + " minutos.");
                        cabinaSeleccionada.registrarLlamada(duracion);
                        System.out.println("Llamada registrada en la cabina de tipo " + tipo);
                    } else {
                        System.out.println("Selección no válida.");
                    }
                    break;

                case 3:
                    System.out.println("Seleccione la cabina:");
                    for (int i = 0; i < cabinas.size(); i++) {
                        System.out.println(i + 1 + ". Cabina " + (i + 1));
                    }

                    seleccionCabina = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (seleccionCabina >= 0 && seleccionCabina < cabinas.size()) {
                        cabinas.get(seleccionCabina).mostrarInformacion();
                    } else {
                        System.out.println("Selección no válida.");
                    }
                    break;

                case 4:
                    int totalLlamadas = 0;
                    int totalDuracion = 0;
                    double totalCosto = 0.0;
                    for (Llamada cabina : cabinas) {
                        totalLlamadas += cabina.numeroLlamadas;
                        totalDuracion += cabina.duracionTotal;
                        totalCosto += cabina.costoTotal;
                    }
                    System.out.println("Consolidado total de todas las cabinas:");
                    System.out.println("Número total de llamadas: " + totalLlamadas);
                    System.out.println("Duración total de las llamadas: " + totalDuracion + " minutos");
                    System.out.println("Costo total: $" + totalCosto);
                    break;

                case 5:
                    System.out.println("Seleccione la cabina para reiniciar:");
                    for (int i = 0; i < cabinas.size(); i++) {
                        System.out.println(i + 1 + ". Cabina " + (i + 1));
                    }

                    seleccionCabina = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (seleccionCabina >= 0 && seleccionCabina < cabinas.size()) {
                        cabinas.get(seleccionCabina).reiniciarCabina();
                        System.out.println("Cabina " + (seleccionCabina + 1) + " reiniciada.");
                    } else {
                        System.out.println("Selección no válida.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
