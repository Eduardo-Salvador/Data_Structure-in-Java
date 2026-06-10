package main.Graphs;

public class Main {
    public static void main(String[] args) {

        GrafoMatriz grafoMatriz = new GrafoMatriz(15);
        grafoMatriz.adicionarAresta(0, 1, 100);
        grafoMatriz.adicionarAresta(0, 2, 80);
        grafoMatriz.adicionarAresta(0, 3, 90);
        grafoMatriz.adicionarAresta(0, 5, 100);
        grafoMatriz.adicionarAresta(0, 8, 60);
        grafoMatriz.adicionarAresta(1, 4, 230);
        grafoMatriz.adicionarAresta(1, 9, 60);
        grafoMatriz.adicionarAresta(1, 10, 50);
        grafoMatriz.adicionarAresta(1, 8, 45);
        grafoMatriz.adicionarAresta(3, 12, 50);
        grafoMatriz.adicionarAresta(3, 2, 150);
        grafoMatriz.adicionarAresta(4, 6, 200);
        grafoMatriz.adicionarAresta(4, 7, 180);
        grafoMatriz.adicionarAresta(6, 13, 190);
        grafoMatriz.adicionarAresta(6, 7, 220);
        grafoMatriz.adicionarAresta(7, 14, 120);
        grafoMatriz.adicionarAresta(7, 11, 260);
        grafoMatriz.adicionarAresta(14, 11, 170);
        grafoMatriz.adicionarAresta(14, 13, 200);
        grafoMatriz.adicionarAresta(5, 9, 100);
        grafoMatriz.adicionarAresta(9, 10, 40);
        grafoMatriz.adicionarAresta(10, 7, 220);

        System.out.println("===== MATRIZ DE ADJACÊNCIA =====");
        grafoMatriz.exibirMatriz();
        System.out.println("\n===== VIZINHOS DE RIBEIRAO PRETO =====");
        grafoMatriz.vizinhos(4);
        System.out.println("\n===== VIZINHOS DE MARILIA =====");
        grafoMatriz.vizinhos(14);
        System.out.println("\n===== VIZINHOS DE PIRACICABA =====");
        grafoMatriz.vizinhos(9);

        System.out.println("==========================================================================");

        GrafoLista grafoLista = new GrafoLista(15);
        grafoLista.adicionarAresta(0, 1, 100);
        grafoLista.adicionarAresta(0, 2, 80);
        grafoLista.adicionarAresta(0, 3, 90);
        grafoLista.adicionarAresta(0, 5, 100);
        grafoLista.adicionarAresta(0, 8, 60);
        grafoLista.adicionarAresta(1, 4, 230);
        grafoLista.adicionarAresta(1, 9, 60);
        grafoLista.adicionarAresta(1, 10, 50);
        grafoLista.adicionarAresta(1, 8, 45);
        grafoLista.adicionarAresta(3, 12, 50);
        grafoLista.adicionarAresta(3, 2, 150);
        grafoLista.adicionarAresta(4, 6, 200);
        grafoLista.adicionarAresta(4, 7, 180);
        grafoLista.adicionarAresta(6, 13, 190);
        grafoLista.adicionarAresta(6, 7, 220);
        grafoLista.adicionarAresta(7, 14, 120);
        grafoLista.adicionarAresta(7, 11, 260);
        grafoLista.adicionarAresta(14, 11, 170);
        grafoLista.adicionarAresta(14, 13, 200);
        grafoLista.adicionarAresta(5, 9, 100);
        grafoLista.adicionarAresta(9, 10, 40);
        grafoLista.adicionarAresta(10, 7, 220);

        System.out.println("\n===== LISTA DE ADJACÊNCIA =====");
        grafoLista.exibirLista();
        System.out.println("\n===== VIZINHOS DE SÃO PAULO =====");
        grafoLista.vizinhos(0);
        System.out.println("\n===== VIZINHOS DE CAMPINAS =====");
        grafoLista.vizinhos(1);
        System.out.println("\n===== VIZINHOS DE BAURU =====");
        grafoLista.vizinhos(7);
    }
}
    