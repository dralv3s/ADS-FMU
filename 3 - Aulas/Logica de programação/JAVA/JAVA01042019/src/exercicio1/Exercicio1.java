/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

import java.util.Scanner;
import org.omg.CORBA.SystemException;

/**
 *
 * @author 3448693
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Bem-Vindo, digite qualquer numero para comercar");
        
        ChecaCondicoes(scan); 
    }   
    
    public static void ChecaCondicoes(Scanner scan){
       try{            
           int numb = scan.nextInt();
           
           if (numb > 0){
               System.out.println("O numero " + numb + " é maior que zero, portanto é positivo");
           }else if(numb < 0){
               System.out.println("O numero " + numb + " é menor que zero, portanto é negativo");
           }else{
               System.out.println("O numero " + numb + " é igual a zero, portanto é nulo");
           } 
       }
       catch(SystemException e){
        
           System.out.println(e.toString());
       }
    }    
}

