package br.com.dev.gui;

public class Potencia extends Operador{

       public Potencia(){
             setSimbolo('^');
       }

       @Override
       public double calcula(double valor1, double valor2) {
             return Math.pow(valor1,valor2);
       }

}