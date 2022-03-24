import domain.Grafo;
import domain.util.FileTo;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/matriz_ejemplo_copy.csv"));

        System.out.println(grafo.dijkstra(4, 6));
        System.out.println("Los vertices aislados o vertices (sólo uno del grupo) que pertenecen a grupos aislados son:" + grafo.hayAislados().toString());
        
        //System.out.println(grafo.dfs(1));
        //grafo.contador=1;
        //System.out.println(grafo.dfs(6));
    }
}
