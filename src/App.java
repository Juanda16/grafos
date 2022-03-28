import domain.model.Grafo;
import domain.util.FileTo;
import domain.view.Index;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/Matriz_de_tiempos_Prueba.csv"));
        //System.out.println(grafo.hayAislados().toString());
        Index.mainScreen(grafo);
    }
}
