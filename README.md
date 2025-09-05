## TDE01 - Resolução de Problemas Estruturados em Computação

Este projeto contém **4 programas Java independentes** que implementam **Pilha** e **Fila dinâmicas** e o **Merge de duas filas ordenadas**, buscando cumprir os requisitos do trabalho sem usar bibliotecas/estruturas prontas. Ou seja, todos os programas usam um leitor próprio (caractere a caractere) via System.in (não utilizam Scanner, String, StringBuilder, Vector, List, Math.pow, .length em lógica, matrizes, etc).

### Arquivos

- **PilhaEncadeada:** Pilha dinâmica (lista encadeada) -> insere, remove, imprime;
- **FilaEncadeada:** Fila dinâmica (lista encadeada)-> insere, remove, imprime;
- **MergeEncadeada:** Merge de duas filas encadeadas ordenadas em uma terceira fila ordenada;
- **MergeVetor:** Merge de duas filas de vetor circular ordenadas em uma terceira fila ordenada.

Cada arquivo possui um **main** próprio e roda independentemente. Basta executar o arquivo desejado para teste.

### Funcionamento dos programas

#### PilhaEncadeada
Implementa uma pilha dinâmica utilizando `nós` encadeados e um ponteiro para o topo. Permite a inserção (empilhar) no topo, a remoção (desempilhar) do topo e a impressão do conteúdo do topo para a base, utilizando um leitor próprio de inteiros via `System.in.read()` (sem `Scanner` ou coleções). Quando vazia, a remoção apenas informa essa condição. 

Ao executar o código, será exibido um menu de escolha (inserir, remover, imprimir e sair). Exemplo de entrada: 1 2 3 -> Saída esperada é 3 2 1 ao imprimir. Ao escolher remover, será removido o primeiro elemento da pilha, nessa caso é o 3 e, ao imprimir novamente, a saída esperada é 2 1.

Veja exemplo abaixo:

#### FilaEncadeada
Implementa uma fila dinâmica com `nós` encadeados, ponteiros para o início e o fim, e um contador de tamanho. Permite a inserção (enfileirar) no fim, a remoção (desenfileirar) do início e a impressão do conteúdo do início ao fim, mantendo a disciplina FIFO. Utiliza um leitor próprio (sem bibliotecas proibidas) e, se vazia, a remoção apenas notifica. 

Ao executar o código, será exibido um menu de escolha (inserir, remover, imprimir e sair). Exemplo de entrada: 1 2 3 -> saída esperada é 1 2 3 ao imprimir. Ao escolher remover, será removido o primeiro elemento da fila, nesse caso é o 1 e, ao imprimir novamente, a saída esperada é 2 3.

Veja exemplo abaixo:

#### MergeEncadeada
Lê duas filas encadeadas ordenadas A e B, consome seus elementos por `remove()` e realiza uma intercalação estável escolhendo sempre o menor elemento disponível para inserir em C, produzindo uma terceira fila ordenada. Presume que A e B estejam em ordem crescente, mantém duplicatas, utiliza um leitor próprio e registra o fluxo de remoções. 

Ao executar o programa, será pedido o tamanho da fila A e em seguida os elementos a serem adicionados. Posteriormente, é feito a mesma dinâmica para a fila B. Exemplo: Tamanho da fila A = 2 -> Elementos a serem inseridos = 1 2; tamanho da fila B = 1 -> elemento a ser inserido = 3; Saída será a fila C = 1 2 3.

Veja exemplo abaixo:

#### MergeVetor
Versão do merge utilizando filas em vetor circular, com dados, capacidade, início, fim e tamanho. Cria C com capacidade nA + nB e realiza a intercalação estável de A e B (já ordenadas) para obter C ordenada, consumindo A/B por `remove()` e inserindo com `insere`. Preserva duplicatas, usa um leitor próprio e evita estouro pela capacidade planejada.

Ao executar o programa, deverá ser escolhido o tamanho tanto da fila A quanto da fila B. Posteriormente, deverá ser inserido os elementos de cada fila. Exemplo de uso: Tamanho da fila A = 2; Tamanho da fila B = 1; Entrada da Fila A = 1 3; Entrada da fila B = 2; Saída será a fila C = 1 2 3.

Veja exemplo abaixo:


### Desenvolvedores
Guilherme Felippe Lazari

Danillo Gonçalves Camargo da Silva


