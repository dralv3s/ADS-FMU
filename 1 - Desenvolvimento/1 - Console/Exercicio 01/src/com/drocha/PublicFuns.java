package com.drocha;

import java.util.Scanner;

public class PublicFuns {


    public void StartStuff(){
        System.out.println("Digite o numero correspondente a opção desejada!");
    }

    public int SelectMode(int caseToCheck){

        int resultado = 0;

        switch (caseToCheck){
            case 1:
                resultado = caseToCheck;
                break;
            case 2:
                resultado = caseToCheck;
                break;
            case 3:
                resultado = caseToCheck;
                break;
            case 4:
                resultado = caseToCheck;
                break;
            case 5:
                resultado = caseToCheck;
                break;
            case 6:
                resultado = caseToCheck;
                break;
            case 7:
                resultado = caseToCheck;
                break;
            case 8:
                resultado = caseToCheck;
                break;
            case 9:
                resultado = caseToCheck;
                break;
            case 10:
                resultado = caseToCheck;

                break;
            default:
                System.out.println("Opção não encontrada, tente novamente, para sair digite SAIR");
                break;

        }

        return resultado;
    }


    public void WriteStuff(int stringToPrint){

        System.out.println("Opçao selecionada = " + stringToPrint);

    }



}
