/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv1.pkg2;  
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Atv12 {

    public static int[][] gerarGrafoCompleto(int n) {
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matriz[i][j] = 1;
                matriz[j][i] = 1;
            }
        }
        return matriz;
    }

    public static List<List<Integer>> listaAdjacencias(int[][] matriz) {
        List<List<Integer>> listaAdj = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            List<Integer> adj = new ArrayList<>();
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 1) {
                    adj.add(j);
                }
            }
            listaAdj.add(adj);
        }
        return listaAdj;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de vértices para o grafo completo K_n: ");
        int n = scanner.nextInt();
        
        int[][] grafo = gerarGrafoCompleto(n);
        
        System.out.println("Matriz de Adjacência:");
        for (int[] linha : grafo) {
            for (int valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        
        System.out.println("Lista de Adjacências: " + listaAdjacencias(grafo));
    }
}