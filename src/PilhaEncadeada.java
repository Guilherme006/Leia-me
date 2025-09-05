class PilhaEncadeada {

    static class No {
        int valor;
        No proximo;
    }

    No topo;

    public void insere(int valor) {
        No novoNo = new No();
        novoNo.valor = valor;
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public int remove() {
        if (topo == null) {
            return Integer.MIN_VALUE;
        }
        int valorRemovido = topo.valor;
        topo = topo.proximo;
        return valorRemovido;
    }

    public void imprime() {
        No noAtual = topo;
        if (noAtual == null) {
            System.out.println("(pilha vazia)");
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

    static void imprimir(String texto){
        System.out.print(texto);
    }

    public static void main(String[] args) throws Exception {
        PilhaEncadeada pilha = new PilhaEncadeada();
        while (true) {
            System.out.println("\nPILHA (1=insere, 2=remove, 3=imprime, 0=sair):");
            int opcao = lerInteiro();
            if (opcao == 0) break;
            if (opcao == 1) {
                imprimir("Valor a inserir: ");
                int valor = lerInteiro();
                pilha.insere(valor);
            } else if (opcao == 2) {
                int valorRemovido = pilha.remove();
                if (valorRemovido == Integer.MIN_VALUE)
                    System.out.println("Pilha vazia. Nada removido.");
                else
                    System.out.println("Removido: " + valorRemovido);
            } else if (opcao == 3) {
                pilha.imprime();
            }
        }
    }
}
