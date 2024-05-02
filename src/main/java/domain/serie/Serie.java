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
