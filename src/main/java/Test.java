import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Bienvenidos a la inmersion Java");
        //System.out.println("Pelicula Matrix");

        int fechaLanzamiento = 1999;
        double evaluacion = 4.5;
        boolean incluidoEnElPlanBasico = true;

        String nombre = "Matrix";
        String sinopsis = """
                La mejor pelicula del fin del milenio
                Matrix
                """;

        double mediaEvaluacionUsuario = 0;

        System.out.println(fechaLanzamiento);
        System.out.println(evaluacion);
        System.out.println(incluidoEnElPlanBasico);
        System.out.println("Nombre: " + nombre);
        System.out.println(sinopsis);

        double medioaEvaluacion = (4.5 + 4.8 + 3)/3;
        System.out.println("media de la evaluacion de matrix: " +  medioaEvaluacion);

        if (fechaLanzamiento >= 2023) {
            System.out.println("Pelicula popular en el momento");
        } else {
            System.out.println("Pelicula retro que vale la pena ver");
        }

        for (int i = 0; i < 3; i++){
            Scanner teclado = new Scanner(System.in);
            System.out.println("ingresa la nota o evaluacion que le darias a matrix");
            double notaMatrix = teclado.nextDouble();
            mediaEvaluacionUsuario = mediaEvaluacionUsuario + notaMatrix;
        }

        System.out.println("La media de la pelicula matrix Calculada es: " +mediaEvaluacionUsuario/3);
    }
}

