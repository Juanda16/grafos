import domain.Grafo;
import domain.util.FileTo;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/matriz_ejemplo_copy.csv"));

        System.out.println(grafo.dijkstra(4, 6));
    }
}
