public class App {
    public static void main(String[] args) throws Exception {
        ListaUnidimensional lista = new ListaUnidimensional(40, 0.5);

        BFS.bfs(lista, 20, 40);
    }
}
