/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import java.util.Scanner;

/**
 *
 * @author 3448693
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        System.out.println("Bem-Vindo, digite o primeiro numero para começar");
        
        equacao(scan);
        
    }
    
    public static void equacao(Scanner scan){
        
        
        int a = Integer.parseInt(scan.nextLine());
        System.out.println("Muito bom, digite o segundo numero");
        
        int b = Integer.parseInt(scan.nextLine());
        
        System.out.println("Muito bom, só falta mais um");
        
        int c = Integer.parseInt(scan.nextLine());
        
        
        double delta = Math.pow(b,2) -4*a*c;
        
        if(delta > 0){
            System.out.println("Raizes diferentes");
        }else if(delta == 0){
            System.out.println("Raizes iguais");
        }else{
            System.out.println("não é raizes"); 
        }
        
        //System.out.println(numb1 + " " + numb2 + " " + numb3 + " ");
        
        
    }
    
    
}
