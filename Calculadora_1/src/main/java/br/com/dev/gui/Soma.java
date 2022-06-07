package br.com.dev.gui;

public class Soma extends Operador{

       public Soma(){
             setSimbolo('+');
       }

       @Override
       public double calcula(double valor1, double valor2) {
             return valor1 + valor2;
       }

}