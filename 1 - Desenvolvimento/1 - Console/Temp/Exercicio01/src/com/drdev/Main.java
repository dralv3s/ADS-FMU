
package com.drdev;

import com.drdev.Exercicios.ExControl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ExControl exControl = new ExControl();

        PublicFuns publicFuns = new PublicFuns();

        publicFuns.StartStuff();

        String userInput = scan.nextLine();


        while (!publicFuns.isNumeric(userInput)){
            publicFuns.WriteStuff("\nFormato incorreto de entrada, digite apenas numeros.\nTente Novamente!");
            publicFuns.WriteStuff("");
            userInput = scan.nextLine();

        }

        publicFuns.SelectMode(Integer.parseInt(userInput), exControl, scan);
    }
}