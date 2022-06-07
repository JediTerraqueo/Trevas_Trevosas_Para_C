package br.com.dev.gui;

public class Subtracao extends Operador{

       public Subtracao(){
             setSimbolo('-');
       }

       @Override
       public double calcula(double valor1, double valor2) {
             return valor1 - valor2;
       }

}