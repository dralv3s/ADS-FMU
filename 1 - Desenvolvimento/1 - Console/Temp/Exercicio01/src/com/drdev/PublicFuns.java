package com.drdev;

import com.drdev.Exercicios.ExControl;

import java.util.Scanner;

public class PublicFuns {

    public void StartStuff(){
        System.out.println("Exercicios de 1 à 10. \nDigite o numero correspondente a opção desejada!");

    }



    public int SelectMode(int caseToCheck, ExControl exControl, Scanner scan){

        int resultado = 0;

        resultado = caseToCheck;

        switch (caseToCheck){
            case 1:
                exControl.ex1.Exercicio1();
                break;
            case 2:
                exControl.ex2.Exercicio2();
                break;
            case 3:
                exControl.ex3.Exercicio3();
                break;
            case 4:
                exControl.ex4.Exercicio4();
                break;
            case 5:
                exControl.ex5.Exercicio5();
                break;
            case 6:
                exControl.ex6.Exercicio6();
                break;
            case 7:
                exControl.ex7.Exercicio7();
                break;
            case 8:
                exControl.ex8.Exercicio8();
                break;
            case 9:
                exControl.ex9.Exercicio9();
                break;
            case 10:
                exControl.ex10.Exercicio10();
                break;
            default:
                System.out.println("Opção não encontrada, tente novamente, para sair digite SAIR");
                break;

        }

        return resultado;
    }


    public void WriteStuff(String stringToPrint){

        System.out.println(stringToPrint);

    }


    public void clearScreen(){
           for(int clear = 0; clear < 1000; clear++) {
            System.out.println("\b") ;
        }
    }




    public boolean isNumeric( String input ){
        try
        {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e)
        {
            return false;
        }
    }
}