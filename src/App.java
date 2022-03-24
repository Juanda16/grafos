import domain.Grafo;
import domain.util.FileTo;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/matriz_ejemplo2.csv"));

        System.out.println(grafo.dijkstra(4, 6));

        System.out.println(grafo.getMatrizTripletas());

        grafo.mejorCamino(4, 2);
    }
}
