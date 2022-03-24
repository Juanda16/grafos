package domain;

import java.util.ArrayList;

public class Grafo {

    MatrizTripletas matrizTripletas;
    public int contador=1;

    public Grafo(MatrizTripletas matrizTripletas) {
        this.matrizTripletas = matrizTripletas;
    }

    public MatrizTripletas getMatrizTripletas() {
        return matrizTripletas;
    }

    public void setMatrizTripletas(MatrizTripletas matrizTripletas) {
        this.matrizTripletas = matrizTripletas;
    }

    public int dijkstra(int src, int fin) {

        int V = matrizTripletas.getConfiguracion().getF();
        int[] dist = new int[V];
        // dist[i] guarda la distancia mas corta desde src hasta el vertice i

        boolean[] verticeYaProcesado = new boolean[V];
        // Este arreglo tiene true si el vertice i ya fue procesado

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }
        // La distancia del vertice origen hacia el mismo es siempre 0
        dist[src] = 0;

        // Encuentra el camino mas corto para todos los vertices
        for (int count = 0; count < V - 1; count++) {

            // Toma el vertice con la distancia minima del cojunto de vertices aun no
            // procesados
            // En la primera iteracion siempre se devuelve src
            int u = minDistance(dist, verticeYaProcesado);

            // Se marca como ya procesado
            verticeYaProcesado[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++)

                // Se actualiza la dist[v] solo si no esta en verticeYaProcesado, hay un
                // arco desde u a v y el peso total del camino desde src hasta v a traves de u
                // es
                // mas pequeno que el valor actual de dist[v]
                if (!verticeYaProcesado[v] && matrizTripletas.getValorEn(u, v) > 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + matrizTripletas.getValorEn(u, v) < dist[v])
                    dist[v] = dist[u] + (int) matrizTripletas.getValorEn(u, v);
        }

        // se imprime el arreglo con las distancias
        return dist[fin] == Integer.MAX_VALUE ? -1 : dist[fin];
    }

    // Funcion utilitaria para encontrar el vertice con la distancia minima,
    // a partir del conjunto de los vertices todavia no incluidos en el
    // camino mas corto
    private int minDistance(int[] dist, boolean[] verticeYaProcesado) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        int V = matrizTripletas.getConfiguracion().getF();

        for (int v = 0; v < V; v++)
            if (verticeYaProcesado[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }


    public ArrayList<Integer> hayAislados() throws Exception{
        ArrayList<Integer> listaVertices = new ArrayList<Integer>();

        for (int i = 1; i < matrizTripletas.getConfiguracion().getF(); i++) {
            contador=1;
            if (dfs(i)==1) {
                listaVertices.add(i);
                //System.out.println(dfs(i));
            } 
        }
        return (listaVertices);
        
    }

    public int dfs(int verticeInicio) throws Exception {
        if (verticeInicio >= matrizTripletas.getConfiguracion().getF()) {
            throw new Exception("el vertice no existe");
        }
        int[] visitados = new int[matrizTripletas.getConfiguracion().getF()];
        return DFSRecursivo(visitados, verticeInicio);
    }
    /**
     *
     * @throws java.lang.Exception
     */
    public void dfs() throws Exception {
        this.dfs(0);
    }

    private int DFSRecursivo(int[] visitados, int v) {
        int contadorTemp =0;
        visitados[v] = 1;
        //System.out.println("Visitando " + v);
        for (int w = 0; w < matrizTripletas.getConfiguracion().getF(); w++) {
            if (matrizTripletas.getValorEn(v,w) == 1) {
                if (visitados[w] == 0) {
                    contador++;
                    contadorTemp= contador;
                    DFSRecursivo(visitados, w);
                }

            }
            
        }
        return contador;
    }

}

