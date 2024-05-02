package domain.pelicula;


import domain.model.Titulo;

import java.util.Scanner;

public class Pelicula extends Titulo {

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
