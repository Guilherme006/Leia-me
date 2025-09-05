class FilaEncadeada {

    static class No {
        int valor;
        No prox;
    }

    No inicio;
    No fim;
    int tamanho;

    public void insere(int v) {
        No n = new No();
        n.valor = v;
        n.prox = null;
        if (inicio == null) {
            inicio = n;
            fim = n;
        } else {
            fim.prox = n;
            fim = n;
        }
        tamanho = tamanho + 1;
    }

    public int remove() {
        if (inicio == null) return Integer.MIN_VALUE;
        int v = inicio.valor;
        inicio = inicio.prox;
        if (inicio == null) fim = null;
        tamanho = tamanho - 1;
        return v;
    }

    public void imprime() {
        No p = inicio;
        if (p == null) {
            System.out.println("(fila vazia)");
            return;
        }
        while (p != null) {
            System.out.print(p.valor);
            if (p.prox != null) System.out.print(" ");
            p = p.prox;
        }
        System.out.println();
    }

    static int lerInteiro() throws Exception {
        int c = System.in.read();
        while (c == ' ' || c == '\n' || c == '\r' || c == '\t') c = System.in.read();
        int sinal = 1;
        if (c == '-') { sinal = -1; c = System.in.read(); }
        int v = 0;
        while (c >= '0' && c <= '9') {
            v = v * 10 + (c - '0');
            c = System.in.read();
        }
        return v * sinal;
    }

    static void p(String s){ System.out.print(s); }

    public static void main(String[] args) throws Exception {
        FilaEncadeada fila = new FilaEncadeada();
        while (true) {
            System.out.println("\nFILA (1=insere, 2=remove, 3=imprime, 0=sair):");
            int op = lerInteiro();
            if (op == 0) break;
            if (op == 1) {
                p("Valor a inserir: ");
                int v = lerInteiro();
                fila.insere(v);
            } else if (op == 2) {
                int r = fila.remove();
                if (r == Integer.MIN_VALUE) System.out.println("Fila vazia. Nada removido.");
                else System.out.println("Removido: " + r);
            } else if (op == 3) {
                fila.imprime();
            }
        }
    }
}
