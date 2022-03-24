package domain;

public class Grafo {

    MatrizTripletas matrizTripletas;

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
        src--;
        fin--;
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


    /** Devuelve un vector con la ruta para ir a cada uno de los vértices
     * desde el vértice src.
     * 
     * @param src
     * @return ruta
     */
    public int[] dijkstraModificado(int src){
        //src--;
        int n = matrizTripletas.getConfiguracion().getF();
        int[] ruta = new int[n];
        int[] costoMinimo = new int[n];
        boolean[] visitados = new boolean[n]; 
        int i, j, w, paso;

        for(i = 0; i < n; i++){
            costoMinimo[i] = (int) matrizTripletas.getValorEn(src, i);
            visitados[i] = false;
            ruta[i] = i + 1;
        }
        visitados[src] = true;
        i = 0;
        while(i < n-2){ // ¿n-1 o n-2?
            j = 0;
            while(visitados[j]){
                j++;
            }
            w = j;
            for(j = w + 1; j < n; j++){
                if(!visitados[j] && costoMinimo[j] < costoMinimo[w]){
                    w = j;
                }
            }
            visitados[w] = true;
            i++;
            for(j = 1; j < n; j++){
                if(!visitados[j]){
                    paso = costoMinimo[w] + (int) matrizTripletas.getValorEn(w, j);
                    if(paso < costoMinimo[j]){
                        costoMinimo[j] = paso;
                        ruta[j] = w + 1;
                    }
                }
            }

        }
        return ruta;
    }
}
