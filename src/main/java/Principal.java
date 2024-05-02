import domain.model.Titulo;
import domain.pelicula.Pelicula;
import domain.serie.Serie;
import util.Util;

import java.util.Scanner;

public class Principal {
    public void muestraElMenu() {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        while (opcion != 9) {
            this.limpiarConsola();
            String menu = """
                    Bienvenido(a) a ScreenMatch
                    1) Registrar nueva pelicula
                    2) Registrar nueva serie
                    3) Calcular Tiempo de Maraton
                    
                    9) Salir""";
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    this.limpiarConsola();
                    Pelicula pelicula = new Pelicula();
                    pelicula.ingresoDeFicha(teclado).muestraFichaTecnica(opcion, teclado);
                    break;
                case 2:
                    this.limpiarConsola();
                    Serie serie = new Serie();
                    serie.ingresoDeFicha(teclado).muestraFichaTecnica(opcion, teclado);
                    break;
                case 3:
                    Util tiempo = new Util();
                    while (opcion != 99) {
                        this.limpiarConsola();
                        String menuMaraton = """
                                Bienvenido(a) a ScreenMatch
                                1) Ingresar Pelicula
                                2) Ingresar Serie
                                3) Calcular Tiempo
                                9) Salir""";
                        System.out.println(menuMaraton);
                        opcion = teclado.nextInt();
                        teclado.nextLine();
                        switch (opcion){
                            case 1:
                                this.limpiarConsola();
                                Pelicula peliculaMaraton = new Pelicula();
                                peliculaMaraton.ingresoDeFicha(teclado).muestraFichaTecnica(opcion, teclado);
                                tiempo.suma(peliculaMaraton.getTiempoDuracionMinutos());
                                break;
                            case 2:
                                this.limpiarConsola();
                                Serie serieMaraton = new Serie();
                                serieMaraton.ingresoDeFicha(teclado).muestraFichaTecnica(opcion, teclado);
                                tiempo.suma(serieMaraton.getTiempoDuracionMinutos());
                                break;
                            case 3:
                                this.limpiarConsola();
                                System.out.println("El tiempo total de maraton es: " + tiempo.getSuma());
                                System.out.println("Presione Enter para continuar...");
                                teclado.nextLine();
                                break;

                            case 9:
                                this.limpiarConsola();
                                System.out.println("saliendo de la calculadora");
                                System.out.println("Presione Enter para continuar...");
                                opcion = 99;
                                teclado.nextLine();

                                break;
                            default:
                                this.limpiarConsola();
                                System.out.println("Opcion no Valida");
                                break;
                        }
                    }
                    break;
//                    System.out.println("Ingrese el nombre de la pelicula");
//                    String nombre = teclado.nextLine();
//                    System.out.println("año de lanzamiento");
//                    int fechaLanzamiento = teclado.nextInt();
//                    teclado.nextLine();
//                    System.out.println("ingrese la duracion en minutos de la pelicula");
//                    int duracionEnMinutos = teclado.nextInt();
//                    teclado.nextLine();
//
//                    Pelicula peliculaUsuario = new Pelicula();
//
//                    peliculaUsuario.setNombre(nombre);
//                    peliculaUsuario.setFechaLanzamiento(fechaLanzamiento);
//                    peliculaUsuario.setTiempoDuracionMinutos(duracionEnMinutos);
//
//                    peliculaUsuario.muestraFichaTecnica();
//                    break;
                case 9:
                    System.out.println("saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion no Valida");
                    break;
            }
        }
    }

    public void limpiarConsola() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}
