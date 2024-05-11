import java.util.*;

class BFS {
    public static void bfs(ListaUnidimensional lista, int puntoDeInicio, int objetivo) {
        int[] padre = new int[lista.size()];
        Arrays.fill(padre, -1); // Inicializamos todos los padres como -1
        boolean[] visitado = new boolean[lista.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(puntoDeInicio);
        visitado[puntoDeInicio] = true;

        while (!queue.isEmpty()) {
            int puntoActual = queue.poll();
            System.out.println("Visitando punto: " + puntoActual);

            // Verificar si se trata del objetivo
            if (puntoActual == objetivo) {
                System.out.println("¡Objetivo encontrado en el punto: " + puntoActual + "!");
                // Imprimir el camino
                imprimirCamino(padre, objetivo);
                return;
            }

            // Explorar los puntos adyacentes
            for (int i = 0; i < lista.size(); i++) {
                if (Math.abs(i - puntoActual) == 1 && !visitado[i]) {
                    queue.add(i);
                    visitado[i] = true;
                    padre[i] = puntoActual; // Registramos el padre del nodo i
                }
            }
        }

        // El objetivo no forma parte de los posibles estados
        System.out.println("Objetivo no encontrado en la lista.");
    }

    private static void imprimirCamino(int[] parent, int objetivo) {
        System.out.print("Camino: ");
        List<Integer> path = new ArrayList<>();
        int actual = objetivo;
        while (actual != -1) {
            path.add(actual);
            actual = parent[actual];
        }
        Collections.reverse(path);
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
