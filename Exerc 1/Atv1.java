/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv1.pkg1;
import java.util.*;
public class Atv11 {
    private int[][] matrizAdj;
    private int vertices;
    
    public Atv11(int[][] matriz) {
        this.matrizAdj = matriz;
        this.vertices = matriz.length;
    }
    
    public List<String> arestas() {
        List<String> arestas = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (matrizAdj[i][j] > 0) {
                    arestas.add("(" + i + ", " + j + ")");
                }
            }
        }
        return arestas;
    }
    
    public boolean isDigrafo() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdj[i][j] != matrizAdj[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[] grauVertices() {
        int[] graus = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graus[i] += matrizAdj[i][j];
            }
        }
        return graus;
    }

    public boolean isConexo() {
        boolean[] visitado = new boolean[vertices];
        dfs(0, visitado);
        for (boolean v : visitado) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int v, boolean[] visitado) {
        visitado[v] = true;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdj[v][i] > 0 && !visitado[i]) {
                dfs(i, visitado);
            }
        }
    }

    public boolean isCiclico() {
        boolean[] visitado = new boolean[vertices];
        return dfsCiclo(0, visitado, -1);
    }

    private boolean dfsCiclo(int v, boolean[] visitado, int pai) {
        visitado[v] = true;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdj[v][i] > 0) {
                if (!visitado[i]) {
                    if (dfsCiclo(i, visitado, v)) return true;
                } else if (i != pai) return true;
            }
        }
        return false;
    }
    
    public List<List<Integer>> listaAdjacencias() {
        List<List<Integer>> listaAdj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            List<Integer> adj = new ArrayList<>();
            for (int j = 0; j < vertices; j++) {
                if (matrizAdj[i][j] > 0) {
                    adj.add(j);
                }
            }
            listaAdj.add(adj);
        }
        return listaAdj;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de vértices: ");
        int n = scanner.nextInt();
        
        int[][] matriz = new int[n][n];
        
        System.out.println("Digite a matriz de adjacência (linha por linha, separando os valores por espaço):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        Atv11 grafo = new Atv11(matriz);
        
        System.out.println("Arestas: " + grafo.arestas());
        System.out.println("É digrafo? " + grafo.isDigrafo());
        System.out.println("Grau de cada vértice: " + Arrays.toString(grafo.grauVertices()));
        System.out.println("É conexo? " + grafo.isConexo());
        System.out.println("É cíclico? " + grafo.isCiclico());
        System.out.println("Lista de adjacências: " + grafo.listaAdjacencias());
        
        scanner.close();
    }
}