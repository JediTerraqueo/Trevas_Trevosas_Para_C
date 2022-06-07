package br.com.dev.gui;

public class Multiplicacao extends Operador{

       public Multiplicacao(){
             setSimbolo('*');
       }

       @Override
       public double calcula(double valor1, double valor2) {
             return valor1 * valor2;
       }

}