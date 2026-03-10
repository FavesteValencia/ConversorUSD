package com.conversor;

import java.util.Scanner;

public class Menu {
    public static void mostrarMenu() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n===== CONVERSOR DE MONEDA =====");
            System.out.println("1) USD -> COP");
            System.out.println("2) COP -> USD");
            System.out.println("3) USD -> BRL");
            System.out.println("4) BRL -> USD");
            System.out.println("5) USD -> ARS");
            System.out.println("6) ARS -> USD");
            System.out.println("7) Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Programa finalizado");
                break;
            }

            System.out.print("Ingrese el valor a convertir: ");
            double cantidad = scanner.nextDouble();

            String base = "";
            String destino = "";

            switch (opcion) {

                case 1:
                    base = "USD";
                    destino = "COP";
                    break;

                case 2:
                    base = "COP";
                    destino = "USD";
                    break;

                case 3:
                    base = "USD";
                    destino = "BRL";
                    break;

                case 4:
                    base = "BRL";
                    destino = "USD";
                    break;

                case 5:
                    base = "USD";
                    destino = "ARS";
                    break;

                case 6:
                    base = "ARS";
                    destino = "USD";
                    break;

                default:
                    System.out.println("Opción inválida");
                    continue;
            }

            double tasa = ConversorAPI.obtenerTasa(base, destino);

            double resultado = Conversor.convertir(cantidad, tasa);

            System.out.println("Resultado: " + resultado + " " + destino);
        }
    }
}
