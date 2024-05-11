
public class ListaUnidimensional {
    private double[] lista;

    public ListaUnidimensional(int longitudTotal, double distanciaEntrePuntos) {
        // Calcular la cantidad de puntos necesarios para cubrir la longitud total
        int cantidadPuntos = (int) (longitudTotal / distanciaEntrePuntos);
        lista = new double[cantidadPuntos];
        
        // Inicializar la lista con los valores de cada punto
        for (int i = 0; i < cantidadPuntos; i++) {
            lista[i] = i * distanciaEntrePuntos;
        }
    }

    public int size() {
        return lista.length;
    }

    public double get(int index) {
        return lista[index];
    }
}
