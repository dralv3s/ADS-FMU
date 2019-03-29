package com.drdev.Exercicios;

import com.drdev.PublicFuns;

import java.util.Scanner;

public class Ex1 extends ExMaster{

    public int idadeToIncrement = 50;

    public void Exercicio1(){
        publicFuns.WriteStuff("Exercicio 01" +
                "\n Seja Bem vindo, qual o seu nome?");

        ColetaDados();

        publicFuns.clearScreen();

        publicFuns.WriteStuff("\n\nSeu nome é: ".concat(nome).
                concat("\nSexo: ").concat(sexo).
                concat("\nPossui ").concat(idade).concat(" anos de idade").
                concat("\n\n Seus dados estão correto? \nS = SIM | N = Não"));

        confirma = scan.nextLine();

        CaseDados(ConfirmaDados(confirma), scan);
    }

    public String nome, idade, sexo, confirma;


    public void CaseDados(int caseToCheck, Scanner scan){

        switch (caseToCheck){
            case 0:
                publicFuns.clearScreen();

                publicFuns.WriteStuff("\n\n\n\n\nSeu nome é: ".concat(nome).
                        concat("\nSexo: ").concat(sexo).
                        concat("\nHoje voçe possui ").concat(idade).concat(" anos de idade").
                        concat("\n\n Em 50 anos voçe terá: ").concat(String.valueOf(idadeToIncrement + Integer.parseInt(idade))).concat(" Anos").
                        concat("\n\n\n\n Pressione a tecla ENTER para rodar novamente ou digite SAIR para finalizar."));
                        if (!scan.nextLine().equalsIgnoreCase("sair")){
                            Exercicio1();
                        }
                break;

            case 1:
                Exercicio1();
                break;

            default:
                System.out.println("Opção não encontrada, tente novamente, pressione enter para sair");
                scan.nextLine();
                break;
        }
    }


    public void ColetaDados(){

        nome = scan.nextLine();

        publicFuns.WriteStuff("Qual o seu sexo?");

        sexo = scan.nextLine();

        publicFuns.WriteStuff("Qual a sua idade");

        idade = scan.nextLine();

        while (!publicFuns.isNumeric(idade)){
            publicFuns.WriteStuff("\nFormato incorreto de entrada, digite apenas numeros.\nTente Novamente!");
            idade = scan.nextLine();
        }
    }

    public int ConfirmaDados(String stringToCheck){

        if (stringToCheck.equalsIgnoreCase("s")){
            return 0;
        }else if(stringToCheck.equalsIgnoreCase("n")){
            return 1;
        }else{
            return 2;
        }
    }
}
