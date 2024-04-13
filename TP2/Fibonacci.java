package TP2;

public class Fibonacci {
    public static String getFibonacci(int cantPosiciones){
        return getFibonacci(cantPosiciones, 0, 1);
    }

    public static String getFibonacci(int cantPosiciones, int primerElemento, int segundoElemento){
        if (cantPosiciones == 0){
            return "";
        }
        else if( cantPosiciones >= 1){
            return Integer.toString(primerElemento) + getFibonacci(cantPosiciones - 1, segundoElemento, primerElemento + segundoElemento);
        }   
        else {
            return "No se puede devolver la secuencia de Fibonacci con una cantidad de posiciones negativa";
        }
    }

    public static void main(String[] args) {
        Integer elementos = 25;
        System.out.println("Secuencia de Fibonacci con "+ elementos+" elementos");
        System.out.println(getFibonacci(elementos));
    }

}