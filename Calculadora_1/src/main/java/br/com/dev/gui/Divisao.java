package br.com.dev.gui;

//(1)
public class Divisao extends Operador{

        public Divisao(){
             setSimbolo('/');
       }

       @Override
       public double calcula(double valor1, double valor2) {
             return valor1 / valor2;
       }

}