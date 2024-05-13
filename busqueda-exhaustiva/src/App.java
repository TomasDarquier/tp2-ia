import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        ListaUnidimensional lista = new ListaUnidimensional(70 * 10, 1);

        // Se crea una instancia de Random para generar puntos de origen y objetivo aleatorios
        Random random = new Random();

        BFS.bfs(lista, random.nextInt(701), random.nextInt(701));
    }
}
    
