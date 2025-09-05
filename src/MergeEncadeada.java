class MergeEncadeada {

    static class No {
        int valor;
        No proximo;
    }

    static class Fila {
        No inicio, fim;
        int tamanho;

        void insere(int valor) {
            No novoNo = new No();
            novoNo.valor = valor;
            novoNo.proximo = null;
            if (inicio == null) {
                inicio = novoNo;
                fim = novoNo;
            } else {
                fim.proximo = novoNo;
                fim = novoNo;
            }
            tamanho = tamanho + 1;
        }

        int remove() {
            if (inicio == null) return Integer.MIN_VALUE;
            int valorRemovido = inicio.valor;
            inicio = inicio.proximo;
            if (inicio == null) fim = null;
            tamanho = tamanho - 1;
            return valorRemovido;
        }

        void imprime() {
            No noAtual = inicio;
            if (noAtual == null) {
                System.out.println("Fila vazia");
                return;
            }
            while (noAtual != null) {
                System.out.print(noAtual.valor);
                if (noAtual.proximo != null) System.out.print(" ");
                noAtual = noAtual.proximo;
            }
            System.out.println();
        }
    }

    static Fila merge(Fila filaA, Fila filaB) {
        Fila filaC = new Fila();

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
        Fila filaA = new Fila();
        Fila filaB = new Fila();

        imprimir("Quantidade de elementos da Fila A: ");
        int quantidadeA = lerInteiro();
        imprimir("Insira a Fila A em ordem crescente:\n");
        for (int i = 0; i < quantidadeA; i++)
            filaA.insere(lerInteiro());

        imprimir("Quantidade de elementos da Fila B: ");
        int quantidadeB = lerInteiro();
        imprimir("Insira a Fila B em ordem crescente:\n");
        for (int i = 0; i < quantidadeB; i++)
            filaB.insere(lerInteiro());

        Fila filaC = merge(filaA, filaB);
        System.out.println("Fila C (merge):");
        filaC.imprime();
    }
}
