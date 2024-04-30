import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        double mediaEvaluacionUsuario = 0;

        System.out.println("Bienvenidos a la inmersion Java");

        for (int i = 0; i < 3; i++){
            Scanner teclado = new Scanner(System.in);
            System.out.println("ingresa la nota o evaluacion que le darias a matrix");
            double notaMatrix = teclado.nextDouble();
            mediaEvaluacionUsuario = mediaEvaluacionUsuario + notaMatrix;
        }

        System.out.println("La media de la pelicula matrix Calculada es: " + mediaEvaluacionUsuario/3);
    }
}
