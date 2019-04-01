/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

import java.util.Scanner;

/**
 *
 * @author 3448693
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        System.out.println("Bem-Vindo, digite o primeiro numero para comercar");
        Checavalores(scan);
        
    }    
    
    public static void Checavalores(Scanner scan){
        
        int numb1 = scan.nextInt();
        
        System.out.println("Muito bom, digite o proximo numero");
        
        int numb2 = scan.nextInt();
        
        if(numb1 == numb2){
            System.out.println("Numeros iguais. \nNumero = " + numb1);
            
        }else if(numb1 != numb2){
            if(numb1 > numb2){
                System.out.println("Numeros diferentes. \nNumero " + numb1 + " é maior que " + numb2 + "\n\n\n");
            }else{
                System.out.println("Numeros diferentes. \nNumero " + numb2 + " é maior que " + numb1 + "\n\n\n");
            }             
            main(null);          
        }        
    }
}
