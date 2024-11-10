package atv4grafo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Atv4grafo {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                Scanner scanner = new Scanner(file);

                int n = scanner.nextInt(); // Lê a dimensão da matriz

                // Cria uma matriz quadrada
                int[][] matriz = new int[n][n];

                // Lê a matriz triangular inferior e preenche a matriz completa
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= i; j++) {
                        matriz[i][j] = scanner.nextInt();
                        matriz[j][i] = matriz[i][j]; // Preenche a parte simétrica
                    }
                }

                scanner.close();

                // Exibe a matriz completa
                System.out.println("Matriz completa:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matriz[i][j] + " ");
                    }
                    System.out.println();
                }

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo.");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
        }
    }
}
