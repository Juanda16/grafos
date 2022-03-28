import domain.model.Grafo;
import domain.util.FileTo;
import domain.view.Index;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/matriz_ejemplo.csv"));
        //System.out.println(grafo.hayAislados().toString());
        Index.mainScreen(grafo);
    }
}
