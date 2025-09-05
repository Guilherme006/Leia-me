class MergeVetor {

    static class FilaVetor {
        int[] dados;
        int capacidade;
        int inicio;
        int fim;
        int tamanho;

        FilaVetor(int capacidade) {
            this.capacidade = capacidade;
            dados = new int[capacidade];
            inicio = 0;
            fim = 0;
            tamanho = 0;
        }

        void insere(int valor) {
            if (tamanho == capacidade) {
                return;
            }
            dados[fim] = valor;
            fim = fim + 1;
            if (fim == capacidade) fim = 0;
            tamanho = tamanho + 1;
        }

        int remove() {
            if (tamanho == 0) return Integer.MIN_VALUE;
            int valorRemovido = dados[inicio];
            inicio = inicio + 1;
            if (inicio == capacidade) inicio = 0;
            tamanho = tamanho - 1;
            return valorRemovido;
        }

        void imprime() {
            if (tamanho == 0) {
                System.out.println("Fila vazia");
                return;
            }
            for (int i = 0; i < tamanho; i++) {
                int indice = inicio + i;
                if (indice >= capacidade) indice = indice - capacidade;
                System.out.print(dados[indice]);
                if (i != (tamanho - 1)) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static FilaVetor merge(FilaVetor filaA, FilaVetor filaB) {
        FilaVetor filaC = new FilaVetor(filaA.tamanho + filaB.tamanho);

        int temA = (filaA.tamanho > 0) ? 1 : 0;
        int temB = (filaB.tamanho > 0) ? 1 : 0;
        int valorA = 0, valorB = 0;

        if (temA == 1) {
            valorA = filaA.remove();
            System.out.println("Removido da Fila A: " + valorA);
        }
        if (temB == 1) {
            valorB = filaB.remove();
            System.out.println("Removido da Fila B: " + valorB);
        }

        while (temA == 1 || temB == 1) {
            if (temB == 0 || (temA == 1 && valorA <= valorB)) {
                filaC.insere(valorA);
                if (filaA.tamanho > 0) {
                    valorA = filaA.remove();
                    System.out.println("Removido da Fila A: " + valorA);
                } else temA = 0;
            } else {
                filaC.insere(valorB);
                if (filaB.tamanho > 0) {
                    valorB = filaB.remove();
                    System.out.println("Removido da Fila B: " + valorB);
                } else temB = 0;
            }
        }
        return filaC;
    }

    static int lerInteiro() throws Exception {
        int caractere = System.in.read();
        while (caractere == ' ' || caractere == '\n' || caractere == '\r' || caractere == '\t')
            caractere = System.in.read();
        int sinal = 1;
        if (caractere == '-') {
            sinal = -1;
            caractere = System.in.read();
        }
        int valor = 0;
        while (caractere >= '0' && caractere <= '9') {
            valor = valor * 10 + (caractere - '0');
            caractere = System.in.read();
        }
        return valor * sinal;
    }

    static void imprimir(String texto){
        System.out.print(texto);
    }

    public static void main(String[] args) throws Exception {
        imprimir("Quantidade de elementos da Fila A: ");
        int quantidadeA = lerInteiro();
        imprimir("Quantidade de elementos da Fila B: ");
        int quantidadeB = lerInteiro();

        FilaVetor filaA = new FilaVetor(quantidadeA);
        FilaVetor filaB = new FilaVetor(quantidadeB);

        imprimir("Insira a Fila A em ordem crescente:\n");
        for (int i = 0; i < quantidadeA; i++)
            filaA.insere(lerInteiro());
        imprimir("Insira a Fila B em ordem crescente:\n");
        for (int i = 0; i < quantidadeB; i++)
            filaB.insere(lerInteiro());

        FilaVetor filaC = merge(filaA, filaB);
        System.out.println("Fila C (merge):");
        filaC.imprime();
    }
}
