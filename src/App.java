import domain.Grafo;
import domain.util.FileTo;

public class App {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(FileTo.matrizTripletas("src/matriz_ejemplo.csv"));

        System.out.println(grafo.dijkstra(4, 3));

        System.out.println(grafo.getMatrizTripletas());

        int v = 1;
        int[] ruta = grafo.dijkstraModificado(v);
        System.out.println("Imprimiento el vector de ruta para: " + v);
        for(int num : ruta){
            System.out.println(num);
        }
    }
}
