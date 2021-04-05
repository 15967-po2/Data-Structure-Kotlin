# Estrutura de Dados Simples - Parte II

### Unidade Curricular: Estrutura de Dados e Algoritmos  
### Autor: Nuno Ricardo Martins Cruz
### email: 15967@alunos@ipbeja.pt
### Número: 15967


## Objetivo e explicação detalhada
Este documento tem como objetivo servir de guia explicativo de todo o processo utilizado ao longo do desenvolvimento deste algorítmo, desde o processo de implementação e execução da segunda parte do projeto de avaliação da unidade curricular de Estruturas de Dados e Algoritmos, esta segunda parte do projeto consiste no desenvolvimento de uma aplicação que receba um texto e que organiza numa ávore de pesquisa binária balenceada red-black, bem como o desenvolvimento de um scipt que permita realizar a gestão da memória desta estrutura. A utilização de uma estrutura de dados deste tipo permite uma forma de organizar os dados que possuimos, a ávore de pesquisa binária balanceada *red-black* permite guardar em cada nó da árvore um bit extra que representa a cor, desta forma permite garantir que a árvore se mantém organizada devidamente durante a inserção ou remoção de dados, cada vez que esta árvore é alterada o bit extra que representa a cor do nó é "pintado" de novo de forma a manter a mesma organizada e a respeitar as suas propríedades. Assim sendo a sua utilização de memória é identica á de uma árvore de pesquisa binária  sem estar "colorida" pois cada nó apenas necessita de 1 bit de memória para guarda a cor do mesmo.


**Com a realização desta segunda parte do projeto:**

- Produzir o algoritmo na linguagem *Kotlin* referente á árvore de pesquisa binária balanceada red-black;
- Implementar o algoritmo da árvore de pesquisa binária complementado com script produzido com o objetivo  de realizar a gestão de memória desta estrutura de dados;
- Aplicar os dois algoritmos recebendo uma string de forma a organizar devidamente a informação;


Este documento divide a explicação desta segunda parte em:
1. Produção do algoritmo da estrutura de dados designada por árvore de pesquisa binária balanceada *red-black* bem como script;
2. Implementação dos scripts e análise de resultados;


## Produção do algoritmo e script de gestão de memória

### Fase 1 - Árvore de pesquisa binária balanceada red-black
De forma a ter uma noção do bom funcionamento dos algortimos de estrutura de dados, foi desenvolvido em linguagem *Kotlin* um script de forma a estruturar a informação e testado com valores inteiros de forma a entender o seu funcionamento e deste modo não existiu uma preocupação no que toca á gestão da memória. O script foi desenvolvido a partir de scripts utilizados em outras linguagens, neste caso *Java*. Foram então criados dois ficheiros denominádos por *ArvorePesquisaBinaria.kt* e *ArvoreRedBlack*, o primeiro tem como função distribuir organizadamente a informação por cada nó da estrutura criada em árvore e o segundo responsável por colorir cada nó, ambos são utilizados quer exista uma inserção ou remoção de informação desta estrutura. Esta estrutura de dados deve respeitar cinco propriedades importantes para que uma arvore de pesquisa binária *red-black* funcione corretamente, sendo eles: 
1. a base desta árvore deve permanecer de cor preta;
2. sempre que exista um filho em que este seja *null* deve estar colorido de cor preta;
3. um filho de um nó vermelho é sempre preto;
4. todas as "folhas" possuem a mesma profundidade de preto;
5. todo o percurso desde a raíz da árvore até á folha, deve conter o mesmo número de nós pretos;
Através destas propriedades, o algortimo devem ser construído em redor das mesmas de forma a respeitar as propiedades e permitir o bom funcíonamento de uma estrutura deste género. 
Através do guia prático da unidade curricular foi possivel ter uma melhor noção destas estruturas que iriam ser implementadas nesta segunda parte do projeto, desta forma foram realizados previamente ao desenvolvimento do código.

### Fase 2 - Gestão de memória
De forma a gerir a gestão da memória utilizada pelo algorimo, foi desenvolvido também em linguagem *Kotlin* um script que permitisse a gestão da mesma. Inicialmente são criados dois ficheiros denominádos por *Stack.kt* e *Memory.kt*. De forma a entender este conceito foi realizado o guia prático 5, que nos proporciona um código base em *Java* de forma a implementar mais facilmente este conceito na segunda parte do projeto. Este método de gestão de memória consiste na alocação e reciclagem de blocos de memória, desta forma quando é pedido um bloco de memória para alocar informação esse bloco é disponibilizado, e a reciclagem de blocos de memória que é basicamente, quando um bloco de memória não esta a ser utilizado durante um vário número de ciclos ou esse bloco não é referenciado no código, esse bloco de memória pode ser disponibilizado para ser adicionado nele nova informação, uma reutilização. 

### Fase 3 - Análise de resultados obtidos
Ao pegar numa *sting* constituída por diversas palavras, é possivel observar que este algoritmo pega nesta mesma string e oganiza-a através desta estrutura de dados dividindo-a em pequenas palavras ordenadas. O algoritmo mantém o equilíbrio dos vários ramos constituientes desta árvore, desta forma em comparação com uma árvore de pesquisa binária normal é possivel observar as suas diferenças. Observamos que no que toca á sua inserção de dados (parte organizacional da árvore) ambas demoram aproximadamente o mesmo tempo a povoar, organizadamente, os vários nós da mesma, mas a utilização da árvore de pesquisa binária *red-black* permite realizar pesquisas de forma muito mais eficiente, apesar de a adição de nós a este tipo de árvore demore algum tempo extra em relação a uma árvore binária normal, esse tempo é compensado de seguida nas pesquisas e pode-se vizualizar um aumento progressivo na *performance* das pesquisas consuante o tamanho da informação fornecida for aumentando.
É possível concluír com isto que o uso desta estrutra de dados fornece uma enorme vantagem no que toca á organização da informação bem como a sua pesquisa.


