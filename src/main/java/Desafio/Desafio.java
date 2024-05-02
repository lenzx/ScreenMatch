package Desafio;

import java.util.Scanner;

public class Desafio {
    public static void main (String[] args) {

        double mediaEvaluacionUsuario = 0;
        int numeroDeNotas = 3;
        int contador = 0;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenidos a la inmersion Java");
        while (contador  != numeroDeNotas ){
            System.out.println("Ingresa la nota o evaluación que le darias a matrix");
            double notaMatrix = teclado.nextDouble();
            mediaEvaluacionUsuario = mediaEvaluacionUsuario + notaMatrix;
            contador = contador + 1;
        }
        System.out.println("La media de la pelicula matrix Calculada es: " + mediaEvaluacionUsuario/numeroDeNotas);
    }
}
