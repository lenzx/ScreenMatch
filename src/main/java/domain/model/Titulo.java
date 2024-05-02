package domain.model;

import domain.pelicula.Pelicula;

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