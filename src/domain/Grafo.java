package domain;

import java.util.Stack;

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

    /**Funcion utilitaria para encontrar el vertice con la distancia minima,
     * a partir del conjunto de los vertices todavia no incluidos en el
     * camino mas corto
     * 
     * @param dist
     * @param verticeYaProcesado
     * @return min_index
     */
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
     * @return ruta (la posición 0 es el costo de toda la ruta)
     */
    public int[] dijkstraModificado(int src, int fin){        
        int n = matrizTripletas.getConfiguracion().getF();
        int[] ruta = new int[n+1]; // se crea con n+1 posiciones para guardar el costo de la ruta en la posición 0
        int[] costoMinimo = new int[n];
        boolean[] visitados = new boolean[n]; 
        int i, j, w, paso, costo;

        for(i = 1; i <= n; i++){
            costo = (int) matrizTripletas.getValorEn(src, i);
            costoMinimo[i-1] = costo == 0 ? Integer.MAX_VALUE : costo;
            visitados[i-1] = false;
            ruta[i] = i;
        }
        costoMinimo[src-1] = 0;
        System.out.println("vértice: " + src);
        visitados[src-1] = true;
        i = 1;
        while(i < n-1){ 
            j = 1;
            while(visitados[j-1]){
                j++;
            }
            w = j;
            for(j = w + 1; j <= n; j++){
                if(!visitados[j-1] && costoMinimo[j-1] < costoMinimo[w-1]){
                    w = j;
                }
            }
            visitados[w-1] = true;
            i++;
            for(j = 1; j <= n; j++){
                if(!visitados[j-1]){
                    costo = (int) matrizTripletas.getValorEn(w, j);
                    costo = costo == 0 ? Integer.MAX_VALUE : costo;
                    int costoW = costoMinimo[w-1];
                    paso = costo == Integer.MAX_VALUE || costoW == Integer.MAX_VALUE ? Integer.MAX_VALUE : costoW + costo;
                    if(paso < costoMinimo[j-1]){
                        costoMinimo[j-1] = paso;
                        ruta[j] = w;
                    }
                }
            }

        }
        ruta[0] = costoMinimo[fin-1];
        return ruta;
    }

    /** Muestra el mejor camino posible entre los nodos src y fin. También menciona el costo del camino.
     * 
     * @param src
     * @param fin
     */
    public void mejorCamino(int src, int fin){
        int[] ruta = dijkstraModificado(src, fin);
        if(ruta[0] == Integer.MAX_VALUE){
            System.out.printf("No hay ninguna ruta posible para ir de %d a %d:\n",src, fin);
            return;
        }
        
        int paso, meta = fin;
        Stack<Integer> pilaRuta = new Stack<>();
        paso = ruta[meta];
        while(paso != meta){
            pilaRuta.add(meta);
            meta = paso;
            paso = ruta[meta];
        }
        pilaRuta.add(meta);
        pilaRuta.add(src);
        //System.out.println("La ruta para ir de " + src + " a " + fin + " es");
        System.out.printf("La mejor ruta para ir de %d a %d, con un coste de %d es:\n",src, fin, ruta[0]);
        while(!pilaRuta.empty()){
            System.out.println(pilaRuta.pop());
        }
    }
}
