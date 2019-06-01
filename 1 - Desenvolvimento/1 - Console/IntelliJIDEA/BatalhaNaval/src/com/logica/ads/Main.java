package com.logica.ads;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /* Declaração de variaveis com scopo global pois serão utilizadas em diversas partes da aplicação*/
    static int numJogadas, numColunas, numLinhas, numNavios;

    public static int fatorDivisaoJogadas = 1;

    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {
        GetGameOptions();
        GamePlay();
    }

    /* Rotina de entrada de parametros para o jogo*/
    public static void GetGameOptions(){

        WriteNewLineConsole("Seja bem-vindo ao Batalha Naval 1.0!");
        WriteNewLineConsole("Espero que se divirta!\n");
        WriteNewLineConsole("Legenda:\n");
        WriteNewLineConsole("   → Espaço não revelado\n");
        WriteNewLineConsole("~  → Tiro na água\n");
        WriteNewLineConsole("X  → Navio afundado.\n");

        /* Entrada de dados para montar o tabuleiro */
        WriteNewLineConsole("Digite o numero de colunas para montar o tabuleiro...\n");
        numColunas = ReadInteger();

        WriteNewLineConsole("Digite o numero de linhas para montar o tabuleiro...\n");
        numLinhas = ReadInteger();

        WriteNewLineConsole("Digite o numero de navios que deseja posicionar no tabuleiro...\n");
        numNavios = ReadInteger();

        Loading(200, "Montando o tabuleiro...");
        Loading(200, "Posicionando navios...");

    }

    /* Rotina de tratamento de input do usuario, recebe como string e passa para integer */
    public static int ReadInteger(){

        int tryCountLimit = 5;
        int tryCount = 1;

        String userInput = scanInput.nextLine();

        while ((!isInteger(userInput)) && (tryCount < tryCountLimit) ){
            WriteNewLineConsole("\nFormato incorreto de entrada, digite apenas numeros inteiros.\nTente Novamente!");
            userInput = scanInput.nextLine();
            tryCount ++;
        }

        if (tryCount >= tryCountLimit){
            WriteNewLineConsole("\nNumero maximo de tentativas atingido, saindo...");
            ExitAplication();
            WriteNewLineConsole("\r");
            return 0;
        }
        return Integer.parseInt(userInput);
    }

    /* Rotina para finalizar aplicação sem erros */
    public static void ExitAplication(){
        WriteNewLineConsole("\nJogo finalizado...\nPressione enter para sair...");
        scanInput.nextLine();
        Loading(500, "Saindo...");
    }

    /* Rotina auxiliar para checar se entrada de usuario é valida e pode ser convertida para integer */
    public static boolean isInteger(String input){
        try
        {
            Integer.parseInt(input);
            return true;
        }
        catch( Exception e)
        {
            return false;
        }
    }

    /* Rotina auxiliar para gerar barra de loading */
    public static void Loading(int intervaloMS, String OutPutMsg)  {

        try {
            WriteNewLineConsole("\n"+ OutPutMsg);
            System.out.print("|==                   |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|====                 |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|======               |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|========             |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|==========           |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|============         |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|==============       |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|================     |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|==================   |\r");
            Thread.sleep(intervaloMS);
            System.out.print("|=====================|\n");
            Thread.sleep(intervaloMS);

            System.out.print("\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* Rotina auxiliar para escrever e pular uma linha */
    public static void WriteNewLineConsole(String msg){
        System.out.print(msg + "\n");
    }

    /* Rotina auxiliar para escrever novas linhas no console */
    public static void WriteConsole(String msg){
        System.out.print(msg);
    }

    /* Rotina principal do jogo. */
    public static void GamePlay() {

        /* contador de pontos da partida */
        int pontos = 0;
        /* variável que recebe o resultado dos tiro (true = acerto, false = erro) */
        boolean result;

        /* variável responsável por autenticar a vitória ou derrota do jogador */
        boolean win = true;

        try {
            /* variável responsável por contar o número de numero de jogadas em uma partida */
            numJogadas = 0;

            /*Tratamento de erros:
              não permite que o usuário insira quantidade de navios maior que as posiçoes do tabuleiro */
            if (numNavios == 0 || numNavios > (numColunas * numLinhas)) {
                WriteNewLineConsole("Numero de navios excede o numero de posições disponiveis no tabuleiro.");
                WriteNewLineConsole("Reinicia o jogo e tente novamente.");
            } else {
                /* Matriz para montar o tabuleiro */
                int[][] tabuleiro = new int[numColunas][numLinhas];

                /* Vetor responsável por receber as posições dos tiros */
                int[] tiros = new int[2];

                /* Inicializa a matriz do tabuleiro */
                MontaTabuleiro(tabuleiro);

                /* Sorteia a posição dos navios */
                PosicionaNavios(tabuleiro, pontos);

                /* Condição para o fim do jogo */
                while (pontos < numNavios) {

                    /* Exibe o tabuleiro no console */
                    ImprimeGrid(tabuleiro);

                    /* Recebe as posições onde o usuário quer atirar e retorna true ou false */
                    result = shoot(tiros, tabuleiro);

                    /* Conta os pontos do usuário */
                    if (result) {
                        pontos++;
                    }

                    numJogadas++;
                    WriteNewLineConsole("Você possui " + pontos + " ponto(s).");

                    if (numJogadas >= ((numColunas * numLinhas) / fatorDivisaoJogadas) +1){
                        win = false;
                        break;
                    }
                }

                /* Finaliza o jogo e exibe resultados da partida*/
                ImprimeGrid(tabuleiro);
                EndGame(win);
            }
        } catch (NegativeArraySizeException | IllegalArgumentException e) {
            /* Tratamento de exceções:
                Encerra o jogo caso usuario insira valores incorretos para modelagem do tabuleiro */
            ExitAplication();
        }
    }

    /* Rotina de checagem de replay */
    public static boolean CheckReplay(){

        int userInput = 0;
        boolean userChoice = false;

        while (userInput != 1 && userInput != 2){
            WriteNewLineConsole("Selecione uma opção para prosseguir!");
            WriteNewLineConsole("Opções");
            WriteNewLineConsole("1 = Jogar novamente.");
            WriteNewLineConsole("2 = Sair.");

            userInput = ReadInteger();

            if (userInput == 1){
                userChoice = true;
            }else if(userInput == 2){
                return userChoice;
            }
        }
        return userChoice;
    }

    //Rotina para checar final de jogo */
    public static void EndGame(boolean win) {

        if (!win) {
            WriteNewLineConsole("\nVocê perdeu o jogo após " + numJogadas + " jogada(s)!");
        } else {
            WriteNewLineConsole("\nVocê venceu o jogo em " + numJogadas + " jogada(s)!");
        }

        /* variável que armazena a opção do usuário:
        iniciar uma nova partida ou sair do jogo */
        boolean playAgain = CheckReplay();

        /* condição para reiniciar ou finalizar o jogo */
        if (playAgain) {
            GamePlay();
        }else {
            ExitAplication();
        }
    }

    /* Metodo para inicializar valores iniciais do tabuleiro */
    public static void MontaTabuleiro(int[][] tabuleiro) {
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
                tabuleiro[i][j] = -1;
            }
        }
    }

    /* sorteia aleatoriamente as posições dos navios*/
    public static void PosicionaNavios(int[][] tabuleiro, int pontos) {

        /* Classe Random gera números aleatórios para posicionar navios */
        Random random = new Random();

        /* Conta a quantidade de navios posicionados */
        int cont = 0;

        /* Alocação dos navios em posições aleatórias */
        while (cont < numNavios - pontos) {

            /* Atribui um número aleatório a variável linha, de acordo com os limites informados pelo jogador */
            int linha = random.nextInt(numLinhas);

            /* Atribui um número aleatório a variável coluna, de acordo com os limites informados pelo jogador */
            int coluna = random.nextInt(numColunas);

            if (numJogadas == 0) {
                if (tabuleiro[linha][coluna] != 0) {
                    tabuleiro[linha][coluna] = 0;
                    cont++;
                }
            }
        }
    }

    /* módulo que imprime o tabuleiro no console */
    public static void ImprimeGrid(int[][] tabuleiro) {

        for (int i = 1; i <= numColunas; i++) {
            /* imprime os índices das colunas */
            WriteConsole("\t" + i);
        }
        WriteNewLineConsole("");
        for (int i = 0; i < numLinhas; i++) {
            /* imprime os índices das linhas */
            WriteConsole((i + 1) + "");
            for (int j = 0; j < numColunas; j++) {
                /* imprime posições não atacadas (espaços em branco)*/
                if (tabuleiro[i][j] == -1 || tabuleiro[i][j] == 0) {
                    WriteConsole("\t ");
                } else {
                    /* imprime água (~) caso o jogador tenha disparado um tiro naquele espaço vazio */
                    if (tabuleiro[i][j] == 1) {
                        WriteConsole("\t~");
                    } else {
                        /* imprime navio destruído (X) caso o usuário já tenha disparado contra este navio */
                        if (tabuleiro[i][j] == 2) {
                            WriteConsole("\tX");
                        }
                    }
                }
            }
            WriteNewLineConsole("");
        }
    }

    /* módulo usado pelo usuário para "atirar" */
    public static boolean shoot(int[] tiros, int[][] tabuleiro) {
        try {

            WriteNewLineConsole("Digite a linha da posição onde deseja atirar:");

            /* Linha em que o usuário pretende atirar.
                É subtraído 1, porque o índice de uma matriz começa em 0 e terminar em n-1 */
            tiros[0] = ReadInteger() - 1;
            WriteNewLineConsole("Digite a coluna da posição onde deseja atirar:");

            /* Coluna que o usuário pretende atirar.
                É subtraído 1 porque o índice de uma matriz começa em 0 e terminar em n-1  */
            tiros[1] = ReadInteger() - 1;
            if (tabuleiro[tiros[0]][tiros[1]] == 0) {

                /* Retorna true caso o usuário acerte um navio (valor da posição = 0), escreve valor = 2 (navio destruído) */
                tabuleiro[tiros[0]][tiros[1]] = 2;
                return true;
            } else {
                /* Retorna false caso o usuário erre um navio escondido, caso não haja navio na posição escreve valor = 2(água vazia) */
                if (tabuleiro[tiros[0]][tiros[1]] == -1) {
                    tabuleiro[tiros[0]][tiros[1]] = 1;
                }
                return false;
            }
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {

            /* Tratamento de exceções:
                Evita que o usuário insira um valor fora dos limites do tabuleiro, ou valores não numéricos */
            WriteNewLineConsole("Insira valores NUMÉRICOS dentro dos limites do tabuleiro!");

            /* Subtrai 1 do numero de numJogadas para não adicionar o erro como jogada valida */
            numJogadas --;
            return false;
        }
    }
}




