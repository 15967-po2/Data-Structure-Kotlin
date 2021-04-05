# Grafos - Parte III

### Unidade Curricular: Estrutura de Dados e Algoritmos  
### Autor: Nuno Ricardo Martins Cruz
### email: 15967@alunos@ipbeja.pt
### Número: 15967

## Objetivo e explicação detalhada
Este documento tem como objetivo servir de guia explicativo de todo o processo utilizado ao longo do desenvolvimento deste algorítmo, desde o processo de implementação e execução da terceira parte do projeto de avaliação da unidade curricular de Estruturas de Dados e Algoritmos, esta terceira parte do projeto consiste no desenvolvimento de uma aplicação que recebe uma tabela de N distâncias entre diversos nós, e utiliza o algortimo de gráfos de forma a estimar os caminhos mais curtes entre cada nó. Para isso foi desenvolvido um algortimo que pretende estimar a distância entre cada nó, e desta forma estimar qual o caminho mais curte entre cada nó, para isso o algortimo foi complementado com o algortimo de Dijkstra, este algoritmo conclui qual o caminho mais curto entre dois nós. Mas o implementado neste algoritmo que é uma variante deste algoritmo recebe como "fonte" um nó e a partir dai calcula qual os caminhos mais curtos para todos os outros nós de forma a produzir uma "árvore" com a rota mais curta de forma a cobrir todos os nós tendo em conta o início dado como a "fonte". Pode ainda ser utilizado como forma de descobrir qual o caminho mais curto entre um determinado nó de origem até um determinado destino, e assim que o caminho mais curto é encontrado o algoritmo pára.


**Com a realização desta segunda parte do projeto:**

- Produzir algoritmo que permite construír os caminhos mais curtos entre os determinados nós, na linguagem *Kotlin*;
- Implementar algoritmo desenvolvido anteriormente de forma a que ordene os caminhos mais curtos através da utilização da teoria de grafos;


Este documento divide a explicação desta terceira parte em:
1. Produção do algoritmo da estrutura de dados designada por teoria dos gráfos;
2. Implementação do algoritmo e análise de resultados obtidos;


## Produção do algoritmo


### Fase 1 - Algoritmo da teoria de grafos
De forma a ter uma noção do bom funcionamento dos algortimos de estrutura de dados, foi desenvolvido em linguagem *Kotlin* um script de forma a estruturar a informação e testado de forma a garantir que responde á necessidade pretendida, neste caso seria a elaboração das rotas de um grafo da forma mais eficiente possivel. Portanto o script encontra-se no ficheiro *Grafos.kt*, e têm como função elaborar as rotas de um dado grafo com determinadas distâncias entre cada nó. 
Algoritmo funciona da seguinte forma, é lhe passado o número de nós presentes no grafo, bem como as devidas distâncias entre cada nó, de forma a representar o grafo. Inicia-se então com o mapeamento do grafo, defenindo em que posição se encontra cada nó e a que distância e que lingações apresentam com outros nós do grafo, de seguida é então aplicado o algoritmo de Dijkstra, que têm como função mapear qual a solução mais eficiente de forma a percorrer todos os nós do grafo tendo em conta um ponto de origem (source). Desta forma os vértices são percorridos e um ciclo é utilizado de forma a comparar todas as opções possiveis para o vértice seguinte, sendo esta a solução mais curta e eficiente. A parte final do script representa o output obtido pelo algoritmo. Portanto o script é responsável por guardar uma "árvore" que representa a solução mais eficiente dada pelo algoritmo ao percorrer determinado grafo.


### Fase 2 - Análise de resultados obtidos
Através da aplicação e desenvolvimento deste script é então claramente notório a elevada importância dada a este assunto, uma vez que é uma forma de solucionar problemas práticos do dia-a-dia. Este tipo de pensamento pode ser aplicado em casos práticos, como defenir qual a rota que uma dada carrinha de transportes de mercadoria deve percorrer de forma mais eficiente, para que os gastos sejam reduzidos, quer de tempo quer de combustíveis. 

