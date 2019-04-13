/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_ex01;

import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Logica_Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float numb[] = new float[2];
        
        Gretings("Seja bem vindo! \nDigite o primeiro numero.");
        
        numb[0] = GetOperators();   
        
        Gretings("Digite o segundo numero.");
        
        numb[1] = GetOperators();
        
        Gretings("Calculando, aguarde um momento");
       
             
    }
        
    
    public static void Gretings(String msg){        
        System.out.println(msg);        
    }
    
    public  static  float GetOperators(){        
        
        Scanner scan = new Scanner(System.in);     
       
        String input  = scan.nextLine();      
       
        while (!isNumeric(input)){
                        
            Gretings("\nFormato incorreto de entrada, digite apenas numeros.\nTente Novamente!");
            input  = scan.nextLine();
        } 
        
        return Float.parseFloat(input); 
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
    
    
    
    public static void  WriteResult(){
    }
    
    
}

