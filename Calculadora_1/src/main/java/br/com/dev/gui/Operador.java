package br.com.dev.gui;

//(1)
public abstract class Operador {

       //(2)
       private char simbolo;

       //(3)
       public abstract double calcula(double valor1, double valor2);


       public char getSimbolo(){
             return this.simbolo;
       }


       public void setSimbolo(char simbolo){
             this.simbolo = simbolo;
       }


}