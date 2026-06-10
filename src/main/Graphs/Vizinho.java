package main.Graphs;

public class Vizinho {
    private Integer cidade;
    private Integer distancia;

    public Vizinho(Integer cidade, Integer distancia) {
        this.cidade = cidade;
        this.distancia = distancia;
    }

    public Integer getCidade() {
        return cidade;
    }

    public Integer getDistancia() {
        return distancia;
    }
}
