#include <stdio.h>

#define MAX_VERTICES 10

void imprimirArestas(int matriz[MAX_VERTICES][MAX_VERTICES], int numVertices) {
    printf("Arestas e seus pesos:\n");
    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            if (matriz[i][j] != 0) {
                printf("(%d, %d) -> Peso: %d\n", i + 1, j + 1, matriz[i][j]);
            }
        }
    }
}

int main() {
    int matriz[MAX_VERTICES][MAX_VERTICES];
    int numVertices;

    // Leitura do número de vértices
    printf("Digite o número de vértices do grafo (max %d): ", MAX_VERTICES);
    scanf("%d", &numVertices);

    // Leitura da matriz de adjacências
    printf("Digite a matriz de adjacências (%d x %d):\n", numVertices, numVertices);
    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            scanf("%d", &matriz[i][j]);
        }
    }

    // Impressão das arestas
    imprimirArestas(matriz, numVertices);

    return 0;
}