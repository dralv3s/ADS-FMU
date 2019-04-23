package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Menu();

        }catch( Exception e)
        {
            Writer("Ocorreu algum erro durante a execução do programa.\nTente novamente, se o erro persistir contate o administrador do sistema!");
        }
    }

    public static void Ex01(){

        Writer("Digite sua altura para começar");

        String input = Reader();

        float altura = InputToFloat(input);

        Writer("Digite seu peso");

        input = Reader();

        float peso = InputToFloat(input);

        Writer("Quantas horas voce se exercita por dia?");

        input = Reader();

        float exercicio = InputToFloat(input);

        Loading(250);

        float imc =  (float)(peso / Math.pow(altura, 2f)) ;
        Writer("Seu IMC é igual a : " + imc);

        ExitAplication();
    }

    public static void Ex02(){

        String TringuloType;

        Writer("Digite o primeiro valor para iniciar.");

        String input = Reader();
        float a = InputToFloat(input);

        Writer("Digite o segundo valor.");

        input = Reader();
        float b = InputToFloat(input);

        Writer("Digite o ultimo valor");

        input = Reader();
        float c = InputToFloat(input);

        if ((a < (b+c)) && (b< (a+b)) && (c< (a+b))){

            if((a == b) && (b == c)){
                TringuloType = "Equilátero";

            }else if(((a == b) && (b == c)) || (a == c)){
                TringuloType = "Isósceles";

            }else{
                TringuloType = "Escaleno";
            }

            Loading(250);

            Writer("\nValores formam um triangulo do tipo " + TringuloType);

        }else{
            Writer("Valores não formam um triangulo.");
        }

        ExitAplication();
    }

    public static void Ex03(){

        Writer("Calculo de tempo de viagem.\n");
        Writer("Digite a velocidade média em km's.");

        String input = Reader();

        float velocidade = InputToFloat(input);

        velocidade = velocidade * 1000;

        Writer("Digite a distancia percorrida em KM's.");

        input = Reader();

        float distancia = InputToFloat(input);
        distancia = distancia * 1000;

        Loading(250);

        float tempo = distancia / velocidade;

        Writer("O tempo médio de viagem é de " + tempo + " Horas");

        ExitAplication();
    }

    public static void Ex04(){
        ExitAplication();
    }

    public static void Ex05(){

        Writer("Jogo do numero aleatorio!");
        Writer("Voce possui cinco tentativas para acertar o numero que foi sorteado de 0 a 100");

        Random rand = new Random();
        int randomico = rand.nextInt(101);

        String input = "";

        float palpite  = 0;

        boolean acertou = false;

        String feedBack = "";

        for (int i = 1; i <= 5; i++){

            Writer("\n\nTentativa " + i );
            input = Reader();

            palpite  = InputToFloat(input);

            if (palpite == randomico){
                acertou = true;
                i = 10;
            }else{
                acertou = false;

                if (palpite < randomico){
                    //feedBack = "Errou, o numero sorteado é maior que " + palpite;
                    //Writer(feedBack);
                    Writer("Errou, o numero sorteado é maior que " + palpite);
                }else{
                    Writer("Errou, o numero sorteado é menor que " + palpite);
                }
            }
        }

       if(acertou){
           Writer("\nParabens, voce acertou, o numero sorteado é " + randomico);
       }else{
           Writer("\nSuas tentativas acabaram, o numero sorteado é " + randomico + "\nMelhor sorte na proxima.\nSaindo...");
       }
        ExitAplication();
    }

    public static void Ex06(){

        ExitAplication();
    }

    public static void Ex07(){

        ExitAplication();
    }

    public static float InputToFloat(String input){

        input = input.replace(",", ".");

        while (!isNumeric(input)){
            Writer("\nFormato incorreto de entrada, digite apenas numeros inteiros.\nTente Novamente!");
            input  = Reader().replace(",", ".");
        }
        return Float.parseFloat(input);
    }

    public static void Menu(){

        Writer("Seja bem vindo, digite o numero da atividade que gostaria de iniciar\n");

        Writer("1 - IMC");

        Writer("2 - Verificar triangulo");

        Writer("3 - Calculo de tempo de viagem");

        Writer("4 - Onibus Espacial");

        Writer("5 - Aleatorio");

        Writer("6 - Calculo de idade");

        Writer("7 - Calculo de esfera\n");

        String input = Reader();

        input = input.replace(",", ".");

        while (!isNumeric(input)){
                Writer("\nFormato incorreto de entrada, digite apenas numeros inteiros.\nTente Novamente!");
                input  = Reader();
        }

        if (!CheckRangeSelectorOK(input)){
            Writer("\nExercicio não encontrado.\nTente Novamente!\n\n");
            Menu();
        }else{
            Selector(input);
        }
    }

    public static boolean CheckRangeSelectorOK(String input){

        try
        {
            int valIn = Integer.parseInt(input);

            if (valIn >= 1 && valIn <= 7){
                return true;
            }
            return false;
        }
        catch( Exception e)
        {
            return false;
        }
    }

    public static void Selector(String input){

        switch (Integer.parseInt(input)){
            case 1:
                Ex01();
                break;
            case 2:
                Ex02();
                break;
            case 3:
                Ex03();
                break;
            case 4:
                Ex04();
                break;

            case 5:
                Ex05();
                break;
            case 6:
                Ex06();
                break;
            case 7:
                Ex07();
                break;
            default:
                break;
        }
    }

    public static String Reader(){
        //metodo Reader para ser invocado quando necessario ler entrada de usuario

        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine();
        return entrada.replace(",", ".");
    }

    public static void Writer(String msg){
        //metodo Writer para ser invocado quando necessario escrever saida algo para o usuario
            System.out.print(msg + "\n");
    }

    public static boolean isNumeric(String input){
        try
        {
            Float.parseFloat( input);
            return true;
        }
        catch( Exception e)
        {
            return false;
        }
    }

    public static void Loading(int intervaloMS)  {

        try {
            Writer("\nExecutando tarefa...\nAguarde por favor!\n");
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
            System.out.print("|=====================|\r");
            Thread.sleep(intervaloMS);

            System.out.print("Done!" + "\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void ExitAplication(){

        Writer("\n\nExercicio finalizado...\nPressione enter para sair...");
        String input = Reader();
        Loading(500);
    }
}



