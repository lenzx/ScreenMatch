# ScreenMatch

Este repositorio contiene un script en Java que brinda una experiencia interactiva al usuario para ingresar información sobre películas y series. Posteriormente, muestra una ficha técnica con los datos ingresados. Además, ofrece la funcionalidad de calcular el tiempo necesario para ver una selección de películas y/o series.

## Características:

- **Registro de Películas y Series:**
  
- **Visualización de Ficha Técnica:** 

- **Cálculo del Tiempo de Maratón:** 

## Cómo usar:

1. Ejecuta el script `Main.java`.
2. Sigue las instrucciones en pantalla para registrar películas y series.
3. Utiliza la opción de cálculo de tiempo para planificar tus maratones de visualización.

## Cómo funciona
El funcionamiento del sistema se basa en una estructura de clases en Java que permite interactuar con el usuario para registrar películas y series, mostrar sus fichas técnicas y calcular el tiempo necesario para ver una selección de películas y/o series.

### Titulo
La clase "Titulo" actúa como la base del sistema y es la clase padre de las clases "Pelicula" y "Serie". Contiene los atributos principales compartidos, como el nombre, la fecha de lanzamiento, la sinopsis y la duración en minutos. Además, proporciona métodos para ingresar estos datos y mostrar la ficha técnica en la consola.

```java
package domain.model;

import java.util.Scanner;

public class Titulo {

    private String nombre;
    private int fechaLanzamiento;
    private double evaluacion;
    private boolean incluidoEnElPlanBasico;
    private String sinopsis;
    private int tiempoDuracionMinutos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public boolean isIncluidoEnElPlanBasico() {
        return incluidoEnElPlanBasico;
    }

    public void setIncluidoEnElPlanBasico(boolean incluidoEnElPlanBasico) {
        this.incluidoEnElPlanBasico = incluidoEnElPlanBasico;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getTiempoDuracionMinutos() {
        return tiempoDuracionMinutos;
    }

    public void setTiempoDuracionMinutos(int tiempoDuracionMinutos) {
        this.tiempoDuracionMinutos = tiempoDuracionMinutos;
    }

    public void muestraFichaTecnica(int opcion, Scanner scanner) {
        this.limpiarConsola();
        System.out.println("****FICHA TÉCNICA****");
        if (opcion == 1){
            System.out.println("Nombre de la pelicula: " + this.getNombre());
        } else if (opcion == 2) {
            System.out.println("Nombre de la serie: " + this.getNombre());
        }
        System.out.println("Fecha de Lanzamiento: " + this.getFechaLanzamiento());
        System.out.println("Tiempo de Duracion: " + this.getTiempoDuracionMinutos());

        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public Titulo ingresoDeFicha(Scanner teclado){
        String nombre = this.ingresoTitulo(teclado);
        int lanzamientos = this.ingresoFechaLanzamiento(teclado);
        int duracion = this.ingresoDuracionMinutos(teclado);
        this.setNombre(nombre);
        this.setFechaLanzamiento(lanzamientos);
        this.setTiempoDuracionMinutos(duracion);
        return this;
    }

    public String ingresoTitulo(Scanner teclado) {

        System.out.println("Ingrese el nombre de la pelicula");
        return teclado.nextLine();
    }
    public  int ingresoFechaLanzamiento(Scanner teclado) {

        System.out.println("año de lanzamiento");
        return teclado.nextInt();
    }
    public int ingresoDuracionMinutos(Scanner teclado) {

        System.out.println("ingrese la duracion en minutos de la pelicula");
        return teclado.nextInt();
    }
    public void limpiarConsola() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}
```


### Pelicula 

La clase "Pelicula" es una subclase de "Titulo" y hereda todos sus métodos y atributos. Adicionalmente, tiene un atributo adicional para el director de la película.

```java
package domain.pelicula;

import domain.model.Titulo;

public class Pelicula extends Titulo {

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
```


### Serie

La clase "Serie" también es una subclase de "Titulo" y hereda sus métodos y atributos. Sin embargo, para manejar la duración de las series, se sobrescriben los métodos de ingreso de datos (ingresoTitulo y ingresoDuracionMinutos) para solicitar información específica de las series, como el número de temporadas, episodios por temporada y la duración de cada episodio.

``` java
package domain.serie;

import domain.model.Titulo;

import java.util.Scanner;

public class Serie extends Titulo {
    private int temporadas;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    @Override
    public  int getTiempoDuracionMinutos(){
        return this.episodiosPorTemporada * this.minutosPorEpisodio * this.temporadas;
    }
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
    @Override
    public String ingresoTitulo(Scanner teclado){
        System.out.println("Ingrese el nombre de la Serie");
        return teclado.nextLine();
    }
    @Override
    public int ingresoDuracionMinutos(Scanner teclado){
        System.out.println("Ingrese el numero de temporadas");
        this.setTemporadas(teclado.nextInt());
        System.out.println("Ingrese el numero de episodios por temporada");
        this.setEpisodiosPorTemporada(teclado.nextInt());
        System.out.println("Ingrese la duracion en minutos de cada episodio");
        this.setMinutosPorEpisodio(teclado.nextInt());
        return this.getTiempoDuracionMinutos();
    }
}

```
### Principal

La clase "Principal" maneja la lógica del menú interactivo del sistema. Permite al usuario registrar nuevas películas o series, calcular el tiempo total para ver una selección y salir del programa. Utiliza un bucle while para mantener el programa en ejecución hasta que el usuario decida salir. Además, utiliza los métodos de las clases "Pelicula" y "Serie" para mostrar la interfaz correspondiente al registrar una nueva película o serie, respectivamente.



```java
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

```
### Main

La clase "Main" simplemente instancia la clase "Principal" y llama al método muestraElMenu(), lo que inicia la ejecución del programa.
```java

public class Main {
    public static void main (String[] args) {

        Principal principal = new Principal();
        principal.muestraElMenu();
    }
}
```


https://github.com/lenzx/ScreenMatch/assets/123669786/9a20a22b-648b-4e40-883c-fda758f7bf3e



