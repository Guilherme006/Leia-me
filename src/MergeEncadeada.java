class MergeEncadeada {

    static class No {
        int valor;
        No prox;
    }

    static class Fila {
        No inicio, fim;
        int tamanho;

        void insere(int v) {
            No n = new No();
            n.valor = v; n.prox = null;
            if (inicio == null) { inicio = n; fim = n; }
            else { fim.prox = n; fim = n; }
            tamanho = tamanho + 1;
        }

        int remove() {
            if (inicio == null) return Integer.MIN_VALUE;
            int v = inicio.valor;
            inicio = inicio.prox;
            if (inicio == null) fim = null;
            tamanho = tamanho - 1;
            return v;
        }

        void imprime() {
            No p = inicio;
            if (p == null) { System.out.println("(fila vazia)"); return; }
            while (p != null) {
                System.out.print(p.valor);
                if (p.prox != null) System.out.print(" ");
                p = p.prox;
            }
            System.out.println();
        }
    }

    static Fila merge(Fila A, Fila B) {
        Fila C = new Fila();

        int temA = (A.tamanho > 0) ? 1 : 0;
        int temB = (B.tamanho > 0) ? 1 : 0;
        int a = 0, b = 0;
        if (temA == 1) { a = A.remove(); System.out.println("Removido da Fila A: " + a); }
        if (temB == 1) { b = B.remove(); System.out.println("Removido da Fila B: " + b); }

        while (temA == 1 || temB == 1) {
            if (temB == 0 || (temA == 1 && a <= b)) {
                C.insere(a);
                if (A.tamanho > 0) { a = A.remove(); System.out.println("Removido da Fila A: " + a); }
                else temA = 0;
            } else {
                C.insere(b);
                if (B.tamanho > 0) { b = B.remove(); System.out.println("Removido da Fila B: " + b); }
                else temB = 0;
            }
        }
        return C;
    }

    static int lerInteiro() throws Exception {
        int c = System.in.read();
        while (c == ' ' || c == '\n' || c == '\r' || c == '\t') c = System.in.read();
        int sinal = 1;
        if (c == '-') { sinal = -1; c = System.in.read(); }
        int v = 0;
        while (c >= '0' && c <= '9') { v = v * 10 + (c - '0'); c = System.in.read(); }
        return v * sinal;
    }
    static void p(String s){ System.out.print(s); }

    public static void main(String[] args) throws Exception {
        Fila A = new Fila();
        Fila B = new Fila();

        p("Quantidade de elementos da Fila A: ");
        int nA = lerInteiro();
        p("Insira a Fila A em ordem crescente:\n");
        for (int i = 0; i < nA; i++) A.insere(lerInteiro());

        p("Quantidade de elementos da Fila B: ");
        int nB = lerInteiro();
        p("Insira a Fila B em ordem crescente:\n");
        for (int i = 0; i < nB; i++) B.insere(lerInteiro());

        Fila C = merge(A, B);
        System.out.println("Fila C (merge):");
        C.imprime();
    }
}
