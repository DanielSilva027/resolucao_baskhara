/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication33;

import java.util.Scanner;

/**
 *
 * @author samue
 */
public class JavaApplication33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double delta = 0.0;
        double baskharaParte1A = 0.0;
        double baskharaParte1B = 0.0;
        double baskharaParte2 = 0.0;
        String raiz1 = "";
        String raiz2 = "";
        
        
        System.out.println("digite o valor de \"A\"");
        a = in.nextDouble();
        
        System.out.println("digite o valor de \"B\"");
        b = in.nextDouble();
        
        System.out.println("digite o valor de \"C\"");
        c = in.nextDouble();
        
        delta = calcDelta(a, b, c);
        
        if(delta < 0){
            System.out.println("não a raiz reais para delta menor que zero");
            
        }else if(a == 0){
            System.out.println("não a raiz reais para \"A\" = zero");

            
        }else{
            baskharaParte1A = (-b + raizQuadrada(delta));
            baskharaParte1B = (-b - raizQuadrada(delta));
            baskharaParte2 = multiplicacao(2, a);
            raiz1 = divisao(baskharaParte1A, baskharaParte2);
            raiz2 = divisao(baskharaParte1B, baskharaParte2);
            
            
            System.out.println("S = {" + raiz1 + ", " + raiz2 + "}");
        }  
    }
    
    
    public static double calcDelta(double A, double B, double C){
        double delta = 0;
        double aux = 0;
        
        aux = multiplicacao(4, A);
        delta = multiplicacao(B, B) - multiplicacao(aux, C);
        
        return delta;
  
    }
    
    
    public static double multiplicacao(double num,double repetidor){
        double result = 0.0;
        int cont = 0;
        
         if (repetidor < 0){
            while((cont - 1) >= repetidor){
                result = result - num;
                cont--;
            }
                
        }else{
            while((cont + 1) <= repetidor){
                result = result + num;
                cont++;
            }
        }

        
        return result;
    }
    
    
    public static double raizQuadrada(double delta){
        double raiz = 0.0;      
        double radicando = delta;  
        double novaSuposicao = 0.0;  
        double erroAproximacao = 0.0;
        double suposicaoInicial = 0.0;
        double precicaoDaResposta = 0.0001;   //1E-14 
        
       
        if(radicando == 0){
        
        } else{
            //calculando uma suposição proxima do radicando
            while((suposicaoInicial * suposicaoInicial) < radicando){
                suposicaoInicial++;
                
            }
            
            novaSuposicao = radicando / suposicaoInicial;
            //Aplicacao do metodo
            do{
                suposicaoInicial = (suposicaoInicial + novaSuposicao)/2;
                novaSuposicao = radicando / suposicaoInicial;
                
                erroAproximacao = (novaSuposicao * novaSuposicao) - radicando;
                
                //|erroAproximacao| - modulo de erroAproximacao
                if (erroAproximacao < 0){
                    erroAproximacao = erroAproximacao * -1;
         
                }
               
            }while(erroAproximacao > precicaoDaResposta);
            
            raiz = novaSuposicao;
        }
        
        return raiz; 
    }
    
    
    public static String divisao(double dividendo,double divisor){
        String armazenaValores = "";
        double aux = 0;
        int sinal = 0;
        
        if(dividendo < 0 ){
            dividendo = -dividendo;
            sinal++;
            
        }
        if( divisor < 0){
             divisor = -divisor;
             sinal++;
             
        }
        if(sinal == 1){
            armazenaValores = armazenaValores + "- ";
            
        }
        for(int i = 0;i < 5;i++){
            int cont = 0;
            
            aux = dividendo;
            
            while(aux >= divisor){
                aux = aux - divisor;
                cont++;
                
                
            }
            armazenaValores = armazenaValores + cont;
            if(i == 0){
                armazenaValores = armazenaValores + ",";
            }
            dividendo = multiplicacao(aux, 10);
          
        }
        return armazenaValores;
    
    }
}   
