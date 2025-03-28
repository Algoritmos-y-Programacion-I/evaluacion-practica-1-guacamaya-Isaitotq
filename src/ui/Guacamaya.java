package ui;

import java.util.Scanner;

public class Guacamaya {

    // Scanner global para todo el programa
    public static Scanner reader;
    // Arreglos de precios y unidades para todo el programa
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */

// Establecemos cantida Vendida 


public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        int referencias = reader.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }

// Solicitamos Datos al cliente :3
/**
 * Descripción: Este método solicita al usuario el número de referencias de productos diferentes vendidas en el día e 
 * inicializa los arreglos encargados de almacenar precios y cantidades.
 * Precondición: El Scanner reader debe estar inicializado.
 * Precondición: Los arreglos precios y unidades deben estar declarados.
 * Poscondición: Los arreglos precios y unidades quedan inicializados con el número de referencias ingresado.
 */

    public static void solicitarDatos(){
        for(int i=0;i<precios.length;i++){
            System.out.println("Por favor digite el valor de la referecia "+(i+1)+":");
            precios[i]=reader.nextDouble();
            System.out.println("Por favor digite el numero de ventas de la referecia "+(i+1)+":");
            unidades[i]=reader.nextInt();

        }

// Calculamos Total unidades Vendidas   
/**
 * Descripción: Este método solicita al usuario que ingrese el precio y la cantidad vendida para cada referencia de producto.
 * Precondición: Los arreglos 'precios' y 'unidades' deben estar inicializados y tener la misma longitud.
 * Poscondición: Los arreglos 'precios' y 'unidades' quedan llenos con la información ingresada por el usuario.
 * @param el método no tiene parametros
 * @return int total_unidades
 */
    }

    public static int calcularTotalUnidadesVendidas(){
        int total_unidades=0;
        for(int i =0;i<unidades.length;i++){
            total_unidades += unidades[i];
        }


        return total_unidades;
 // Calcular Precios promedio :v       
 /**
 * Descripción: Este método calcula el total de ventas del día multiplicando el precio de cada producto por su cantidad vendida.
 * Precondición: Los arreglos 'precios' y 'unidades' deben estar inicializados y tener la misma longitud.
 * Poscondición: Retorna el total de ventas del día.
 * @param el método no tiene parametros
 * @return int suma_precios/precios.length;
 */
    }

    public static double calcularPrecioPromedio(){
        double suma_precios=0;
        for(int i=0;i<precios.length;i++){
            suma_precios += precios[i];
        }

        return suma_precios/precios.length;

    }
// Calcular ventas totales :D

    public static double calcularVentasTotales(){
        double total_ventas=0;
        for(int i=0;i<precios.length;i++){
            total_ventas += precios[i]*unidades[i];
        }

        return total_ventas;

    }
// Consultamos :P
/**
 * Descripción: Este método cuenta cuántas referencias de productos han generado ventas por encima de un límite especificado.
 * Precondición: Los arreglos 'precios' y 'unidades' deben estar inicializados y contener datos válidos.
 * Poscondición: Retorna el número de referencias de productos cuyas ventas superan el límite ingresado.
 * @param el metodo tiene double limite
 * @return num_Productos 
 */

    public static int consultarReferenciasSobreLimite(double limite){
        int num_productos=0;
        for(int i=0;i<precios.length;i++){
            if(precios[i]*unidades[i] > limite){
                num_productos++;
            }
        }

        return num_productos;

    }

}
