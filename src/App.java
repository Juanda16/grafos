import domain.model.Grafo;
import domain.util.FileTo;
import domain.view.Index;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/Matriz_de_tiempos3.csv"));
        Index.mainScreen(grafo);
        //System.out.println(grafo.dijkstra(1, 200));
        //grafo.mejorCamino(1, 200);
    }
}
