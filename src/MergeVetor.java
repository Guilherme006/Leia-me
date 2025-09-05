class MergeVetor {

    static class FilaVetor {
        int[] dados;
        int capacidade;
        int inicio;
        int fim;
        int tamanho;

        FilaVetor(int cap) {
            capacidade = cap;
            dados = new int[capacidade];
            inicio = 0; fim = 0; tamanho = 0;
        }

        void insere(int v) {
            if (tamanho == capacidade) {
                return;
            }
            dados[fim] = v;
            fim = fim + 1;
            if (fim == capacidade) fim = 0;
            tamanho = tamanho + 1;
        }

        int remove() {
            if (tamanho == 0) return Integer.MIN_VALUE;
            int v = dados[inicio];
            inicio = inicio + 1;
            if (inicio == capacidade) inicio = 0;
            tamanho = tamanho - 1;
            return v;
        }

        void imprime() {
            if (tamanho == 0) { System.out.println("(fila vazia)"); return; }
            int i = 0;
            while (i < tamanho) {
                int idx = inicio + i;
                if (idx >= capacidade) idx = idx - capacidade;
                System.out.print(dados[idx]);
                if (i != (tamanho - 1)) System.out.print(" ");
                i = i + 1;
            }
            System.out.println();
        }
    }

    static FilaVetor merge(FilaVetor A, FilaVetor B) {
        FilaVetor C = new FilaVetor(A.tamanho + B.tamanho);

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
        p("Quantidade de elementos da Fila A: ");
        int nA = lerInteiro();
        p("Quantidade de elementos da Fila B: ");
        int nB = lerInteiro();

        FilaVetor A = new FilaVetor(nA);
        FilaVetor B = new FilaVetor(nB);

        p("Insira a Fila A em ordem crescente:\n");
        for (int i = 0; i < nA; i++) A.insere(lerInteiro());
        p("Insira a Fila B em ordem crescente:\n");
        for (int i = 0; i < nB; i++) B.insere(lerInteiro());

        FilaVetor C = merge(A, B);
        System.out.println("Fila C (merge):");
        C.imprime();
    }
}
