# Complexidade Computacional e Algoritmos de Ordenação - Parte I

### Unidade Curricular: Estrutura de Dados e Algoritmos  
### Autor: Nuno Ricardo Martins Cruz
### email: 15967@alunos@ipbeja.pt
### Número: 15967


## Objetivo e explicação detalhada
Este documento tem como objetivo servir de guia explicativo de todo o processo utilizado ao longo do desenvolvimento deste algorítmo, desde o processo de implementação e execução da primeira parte do projeto de avaliação da unidade curricular de Estruturas de Dados e Algoritmos, esta primeira parte do projeto consiste no desenvolvimento de um algoritmo Bucket-Sort utilizado em complemento com o algoritmo Insertion-Sort. A utilização destas duas técnicas de organização dos dados permite tirar partido dos dois algoritmos em complemento, uma vez que o Bucket-Sort permite dividir os valores em pequenos buckets (baldes) sendo estes ordenados de acordo com uma escala definida, de seguida entra em complemento com este algoritmo o Insertion-Sort. Uma vez que o algoritmo Insertion-Sort apresenta pouca eficiência no que toca a um grande volume de dados, utilizado em complemento com o Bucket-Sort permite aumentar a sua eficiência pois é aplicado em "buckets" com um número de valores mais reduzidos e ainda é considerado de fácil implementação.


**Com a realização desta primeira parte do projecto:**

- Preparar o sistema de forma a implementar e executar os algoritmos de forma eficiente;
- Analisar tempos de execução dos algoritmos implementados de acordo com os dados;
- Retirar de uma imagem monocromática e ordenar os valores de intensidade da cor cinzento da mesma imagem Full HD(1080p) através dos algoritmos Bucket-Sort e Insertion-Sort;


Este documento divide a explicação desta primeira parte em:
1. Preparar o sistema a ser utilizado, com as instalações e updates necessários
2. Implementar os algoritmos Bucket-Sort em complemento com o algoritmo Insertion-Sort, de forma a testar o seu devido funcionamento utilizando uma lista de números décimais.


## Preparação do ambiente de trabalho
De forma a realizar a programação bem como a aplicação destes algoritmos em situações práticas, é necessário recorrer á instalação do *software* bem como algumas bibliotecas necessárias. Segue de seguida uma lista, na qual se encontram todos os passos necessários para realizar a preparação do ambiente a ser utilizando de forma a poder retirar maior partido dos módulos de *Java* com o OpenCV utilizando a linguagem *Kotlin*. É possivel que durante este processo os caminhos descritos possam variar, bem como a escolha do compilador e IDEA utilizado, mas não deve alterar em nada os resultados obtidos no final. 


## Preparação do sistema:

* Máquina Host:
	* Windows 10 Home;
	* Processador - Intel(R) Core(TM) i7-8550U CPU @ 1.80GHz;
	* 16GB de RAM;
	* Gráfica 1 - NVIDIA GeForce 940MX 4GB;
	* Gráfica 2 - Intel UHD Graphics 620;

* Máquina Virtual:
	* OS - Ubuntu 18.04.4 LTS (Bionic Beaver);
	* Processador - Intel(R) Core(TM) i7-8550U CPU @ 1.80GHz;
	* 4 CPUs;
	* 8GB de RAM;
	* Memória Gráfica - 128MB;


Neste pequeno tutorial é possivel observar a elevada utilização do  prefixo **sudo** ao executar os comandos, este permite realizar as tarefas seguintes no modo administrador de forma a garantir uma instalação coesa.
1. Utilizar comando **apt update** e de seguida **apt upgrade** permite realizar atualizações necessáias ao sistema operativo bem como os seus pacotes;
2. Comando **apt-get install build essential cmake cmake-qt-gui unzip pkg-config ccache** de forma a instalar *software* responsável pela compilação;
3. De seguida segue-se a instalação das bibliotecas de leitura e escrita de imagens bem como de vídeos, desta forma é possível retirar elementos da imagem a serem analisados posteriormente,   através dos comandos na ordem seguinte **sudo apt install libjpeg-dev libpng-dev libtiff-dev** , **sudo apt install libavcodec-dev libavformat-dev libswscale-dev libv4l-dev** , **sudo apt install libxvidcore-dev libx264-dev**;
4. Instalar *software* GTK 3 de forma a que seja utilizada uma interface gráfica em alguns *softwares* através do comando **apt-get install libgtk-3-dev**;
5. Instalar bibliotecas numéricas que apresentam um elevado desempenho utilizadas como ordenação de tabelas através do comando **apt-get install libatlas-base-dev gfortran**;
6. Usar o comando **sudo apt install python3-dev python3-numpy** de forma a instalar pacotes de suporte e desenvolvimento do *NumPy* bem como do *Python3*;
7. De seguida instalar pacotes necessários de suporte para *Java* necessários para realizar o **build** no OpenCV através dos comandos **apt-get install default-jdk ant** e **sudo apt install ant**;
8. Foi utilizado o IDEA Intellij-Comunnity version o que não impede que seja utilizado outro, este foi baixado do website da JetBrains através do comando **sudo snap install intellij-idea-community --classic**;
9. Os pacotes referentes ao OpenCV encontram-se num repositŕio github e foram recolhidos e instalados através dos seguintes comandos **git clone https://github.com/opencv/opencv** e **git clone https://github.com/opencv/opencv_contrib**;
10. Deve ser criada uma directoria **build** na **$HOME/build** através do comando **mkdir build** que será utilizada para armazenar o codigo fonte para compilação; 
11. Através do comando **cmake-gui** é executada a versão gráfica do *CMake* que tem como função gerir a função build através do uso compilador escolhido;
12. Os parâmetros da aplicação **cmake-gui** devem ser preenchidos com o local onde se encotra o código fonte original e o local onde será colocado o código para o *build* do pacote. Desta forma os comapos devem ser preenchidos da seguinte forma, campo souce com directoria especificada do OpenCV **../opencv** e build **$HOME/build**;
13. Antes de concluir deve ser indicado no campo **PYTHON3_INCLUDE_DIR** o caminho correspondente do compilador python que se deve encontrar **~/usr/include/python3.6m** caso tenha obtado por instalar noutra directoria deve confirmar o caminho e colocálo antes de prosseguir;
14. De seguida devem ser gerados os ficheiros correspondentes ao build; 
15. Após o estes ficheiros terem sido gerados com sucesso deve ser executado o comando **lscpu** de forma a confirmar quantos núcleos se encontram disponíveis na máquina. Após obter esta informação executar o comando **make -j ncpus** onde o **ncpus** deve ser substituido pelo numero de núcleos devolvidos pelo comando anterior;
16. Por fim após a compilação procede-se á instalação com o uso do comando **sudo make install**;
17. Por fim é necessário configurar no Intellij a utilização da biblioteca OpenCV bem como o compilador a ser utilizado, que será necessário para a extração de alguns parâmetros da imagem. Desta forma é necessário começar por criar um projeto;
18. De seguida ir a **File -> Project Structure -> Modules -> + -> Jars or directories** e utilizar o caminho da pasta build configurada e gerada previamente e indicar o compilador o caminho que contem as bindings de *Java* OpenCV que devem se encontrar, **~/usr/local/share/java/opencv4** e selecione **Apply** e **Ok**;
19. De forma a indicar o compilador a ser utilizado, este deve ser indicado no projeto como a biblioteca OpenCV, deste modo é necessário **File -> Project Structure -> Libraries -> + -> Kotlin J/S** e selecionar o caminho para o qual se encontra o ficheiro **.jar** do OpenCV que deve se encontrar, **~/usr/local/share/java/opencv4**, selecionar com **Apply** e terminar com **Ok**;


## Implementação dos algoritmos e análise dos resultados obtidos 

### Fase 1 - Bucket Sort e Insertion Sort
De forma a ter uma noção do bom funcionamento dos algortimos de ordenação, os mesmos foram utilizados para realizar uma pequena ordenação com valores decimais, desta forma foi apenas observado o funcionamento do algoritmo e assim não existiu uma elevada preocupação no que toca aos tempos de execução pois como o número de valores a ordenar era relativamente pequeno os tempos de execução foram insignificantes. Procedeu-se á comentação do código de forma a perceber a sua estruturação e as diversas fases do mesmo.

### Fase 2 - Execução com diferentes tamanhos de amostras
De forma a obter um tamanho de amostra relevante, o mesmo foi testado com diversos tamanhos de imagens de forma a poder observar o tempo de execução do algortimo tendo como base uma amostra maior e observando o comportamento do mesmo. Desta forma através das medições realizadas foi possivel elaborar um gráfico com o auxilio do **GNUplot** de forma a corresponder aos tempos de execução do algortimo consoante o tamanho da amostra. Foi assim obtido os diferentes tempos de execução:

- Imagem (360p) 640 x 360 - **36132 ms**
- Imagem (480p) 640 x 480 - **102841 ms**
- Imagem (720p / HD) 1280 x 720 - **952556 ms**
- Imagem (1080p / Full HD) 1920 x 1080 - **5059602 ms**

### Fase 3 - Elaboração do gráfico de frequências
Após ter sido realiza a recolha dos pixeis e transcritos ordenadamente de um array para um ficheiro .txt, é então possivel proceder á elaboração de um gráfico de frequências bem ainda o gráfico dos pixeis ordenados, com o auxilio do **GNUplot**. Através da utilização desses mesmos dados obtidos e concentrados no ficheiro .txt foi realizado um outro gráfico de forma a obter a frequência em percentagem, obtendo um máximo de **3.1% (65 826)**. Este gráfico permite ainda uma retirada de conclusões, sendo uma delas bastante visivel que os valores dos tons de cinzentos se encontram maioritariamente concentrados entre 10 e 20.

