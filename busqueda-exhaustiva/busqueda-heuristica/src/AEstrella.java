import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AEstrella {
    public static void aEstrella(ListaUnidimensional lista, int puntoInicio, int objetivo) {
        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        pq.offer(new Nodo(puntoInicio, 0, distanciaManhattan(puntoInicio, objetivo)));
        boolean[] visitado = new boolean[lista.size()];
        int[] padre = new int[lista.size()];
        Arrays.fill(padre, -1);

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int puntoActual = actual.punto;

            if (puntoActual == objetivo) {
                System.out.println("¡Objetivo encontrado en el punto: " + puntoActual + "!");
                // Imprimir el camino
                imprimirCamino(padre, objetivo);
                return;
            }

            if (visitado[puntoActual]) {
                continue;
            }

            visitado[puntoActual] = true;

            // Explorar los puntos adyacentes
            for (int i = 0; i < lista.size(); i++) {
                if (Math.abs(i - puntoActual) == 1 && !visitado[i]) {
                    int g = actual.costo + 1; // Costo del nodo adyacente
                    int h = distanciaManhattan(i, objetivo); // Heuristica del nodo adyacente
                    pq.offer(new Nodo(i, g, h));
                    padre[i] = puntoActual; // Se registra el padre del nodo adyacente
                }
            }
        }

        // El objetivo no forma parte del espacio de estados 
        System.out.println("Objetivo no encontrado en la lista.");
    }

    private static int distanciaManhattan(int a, int b) {
        return Math.abs(a - b);
    }

    private static void imprimirCamino(int[] padre, int objetivo) {
        System.out.print("Camino: ");
        List<Integer> camino = new ArrayList<>();
        int actual = objetivo;
        while (actual != -1) {
            camino.add(actual);
            actual = padre[actual];
        }
        Collections.reverse(camino);
        for (int nodo : camino) {
            System.out.print(nodo + " ");
        }
        System.out.println();
    }
}
