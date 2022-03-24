import domain.Grafo;
import domain.util.FileTo;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/Matriz_de_tiempos3.csv"));

        //System.out.println(grafo.dijkstra(1, 200));
        grafo.mejorCamino(1, 200);
    }
}
