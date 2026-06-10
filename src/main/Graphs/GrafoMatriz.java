package main.Graphs;

public class GrafoMatriz {
    private Integer[][] matriz;

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

    public GrafoMatriz(int quantidadeCidades){
        matriz = new Integer[quantidadeCidades][quantidadeCidades];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public void adicionarAresta(Integer cidade1, Integer cidade2, Integer distancia) {
        matriz[cidade1][cidade2] = distancia;
        matriz[cidade2][cidade1] = distancia;
    }

    public void exibirMatriz() {
        System.out.printf("%25s", "");
        for (Cidade cidade : CIDADES) {
            System.out.printf("%8d", cidade.getId());
        }
        System.out.println();

        for (Integer i = 0; i < matriz.length; i++) {
            System.out.printf("%25s", CIDADES[i].getNome() + "(" + CIDADES[i].getId() + ")");
            for (Integer j = 0; j < matriz[i].length; j++) {
                System.out.printf("%8d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public void vizinhos(Integer cidadeId) {
        System.out.println("\nCidade: "+ CIDADES[cidadeId].getNome() + " (ID " + cidadeId + ")");

        for (Integer i = 0; i < matriz[cidadeId].length; i++) {
            if (matriz[cidadeId][i] != 0) {
                System.out.println("-> " + CIDADES[i].getNome() + " (ID " + CIDADES[i].getId() + ") - " + matriz[cidadeId][i] + " km");
            }
        }
    }
}
