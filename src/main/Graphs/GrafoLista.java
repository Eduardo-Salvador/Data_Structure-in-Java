package main.Graphs;    
import java.util.ArrayList;

public class GrafoLista {
    private ArrayList<Vizinho>[] lista;

    private static Cidade[] CIDADES = {
                new Cidade(0, "São Paulo"),
                new Cidade(1, "Campinas"),
                new Cidade(2, "Santos"),
                new Cidade(3, "São José dos Campos"),
                new Cidade(4, "Ribeirão Preto"),
                new Cidade(5, "Sorocaba"),
                new Cidade(6, "São José do Rio Preto"),
                new Cidade(7, "Bauru"),
                new Cidade(8, "Jundiaí"),
                new Cidade(9, "Piracicaba"),
                new Cidade(10, "Limeira"),
                new Cidade(11, "Presidente Prudente"),
                new Cidade(12, "Taubaté"),
                new Cidade(13, "Araçatuba"),
                new Cidade(14, "Marília")
    };

    public GrafoLista(int quantidadeCidades) {
        lista = new ArrayList[quantidadeCidades];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = new ArrayList<>();
        }
    }

    public void adicionarAresta(Integer cidade1, Integer cidade2, Integer distancia) {
        lista[cidade1].add(new Vizinho(cidade2, distancia));
        lista[cidade2].add(new Vizinho(cidade1, distancia));
    }

    public void exibirLista() {
        for (int i = 0; i < lista.length; i++) {
            System.out.println(CIDADES[i].getNome() + " (ID " + CIDADES[i].getId() + ")" + " -> ");
            for (Vizinho v : lista[i]) {
                System.out.println(CIDADES[v.getCidade()].getNome() + " - " + v.getDistancia() + " km ");
            }
            System.out.println();
        }
    }

    public void vizinhos(Integer cidadeId) {
        System.out.println("\nCidade: "+ CIDADES[cidadeId].getNome() + " (ID " + cidadeId + ")");
        for (Vizinho v: lista[cidadeId]) System.out.println(CIDADES[v.getCidade()].getNome() + " - " + v.getDistancia() + " km ");
    }
}