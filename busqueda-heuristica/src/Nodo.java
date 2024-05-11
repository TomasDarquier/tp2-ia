class Nodo implements Comparable<Nodo> {
    int punto; // Punto en el eje X
    int costo; // Costo acumulado hasta este punto 
    int heuristica; // Heuristica estimada hasta el objetivo (heuristica h)

    public Nodo(int punto, int costo, int heuristica) {
        this.punto = punto;
        this.costo = costo;
        this.heuristica = heuristica;
    }

    @Override
    public int compareTo(Nodo otro) {
        // Comparar por el costo total (costo acumulado + heuristica)
        return Integer.compare(this.costo + this.heuristica, otro.costo + otro.heuristica);
    }
}