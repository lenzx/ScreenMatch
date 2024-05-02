import domain.pelicula.Pelicula;
import domain.serie.Serie;

public class Main {
    public static void main (String[] args) {

//        Pelicula matrix = new Pelicula();
//
//        matrix.setNombre("Matrix");
//        matrix.setTiempoDuracionMinutos(120);
//        matrix.setFechaLanzamiento(1999);
//        matrix.setSinopsis("La mejor pelicula");
//
//        Pelicula encanto = new Pelicula();
//
//        encanto.setNombre("Encanto");
//        encanto.setTiempoDuracionMinutos(120);
//        encanto.setFechaLanzamiento(2022);
//
//        matrix.muestraFichaTecnica();
//        encanto.muestraFichaTecnica();
//
//        Serie friends = new Serie();
//        friends.setNombre("friends");
//        friends.setFechaLanzamiento(1996);
//        friends.setTemporadas(10);
//        friends.setEpisodiosPorTemporada(22);
//        friends.setMinutosPorEpisodio(30);
//        friends.muestraFichaTecnica();

        Principal principal = new Principal();
        principal.muestraElMenu();
    }
}
