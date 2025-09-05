class FilaEncadeada {

    static class No {
        int valor;
        No proximo;
    }

    No inicio;
    No fim;
    int tamanho;

    public void insere(int valor) {
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

    public int remove() {
        if (inicio == null) return Integer.MIN_VALUE;
        int valorRemovido = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        tamanho = tamanho - 1;
        return valorRemovido;
    }

    public void imprime() {
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

    static void imprimir(String texto) {
        System.out.print(texto);
    }

    public static void main(String[] args) throws Exception {
        FilaEncadeada fila = new FilaEncadeada();
        while (true) {
            System.out.println("\nFILA (1=insere, 2=remove, 3=imprime, 0=sair):");
            int opcao = lerInteiro();
            if (opcao == 0) break;
            if (opcao == 1) {
                imprimir("Valor a inserir: ");
                int valor = lerInteiro();
                fila.insere(valor);
            } else if (opcao == 2) {
                int valorRemovido = fila.remove();
                if (valorRemovido == Integer.MIN_VALUE)
                    System.out.println("Fila vazia. Nada removido.");
                else
                    System.out.println("Removido: " + valorRemovido);
            } else if (opcao == 3) {
                fila.imprime();
            }
        }
    }
}
