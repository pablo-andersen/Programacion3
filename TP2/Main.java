package TP2;

public class Main {

        public static boolean arrOrdenadoAsc(int[] arr, int n) {            
            if (n == 0 || n == 1) {
                return true;
            }
            if (arr[n - 1] < arr[n - 2]) {
                return false;
            }
            return arrOrdenadoAsc(arr, n - 1);
        }

        public static boolean buscarValor(int[] arr, int n, int valor) {
            if (n == 0) {
                return false;
            }
            if (arr[n - 1] == valor) {
                return true;
            }
            return buscarValor(arr, n - 1, valor);
        }
        
        public static String obtenerBinario(int valor){
            if (valor == 0 || valor == 1) {
            return Integer.toString(valor);
            }
            else {
                int cociente = valor / 2;
                int resto = valor % 2;
            return obtenerBinario(cociente) + Integer.toString(resto);
            }
        }

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

        public boolean valorIgualIndice (int[] arr){
            return valorIgualIndice (arr, arr.length-1);
        }
        
        public boolean valorIgualIndice (int[] arr, int pos){
            if (pos>=0){
                if(arr[pos] != pos) {
                    return valorIgualIndice(arr, pos-1);
                }
                else {
                    return true;
                }
            }
            else {
                return false;
            }
        }

        public static void main(String[] args) {
            int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            boolean resultado = arrOrdenadoAsc(arreglo, arreglo.length);
            if (resultado) {
                System.out.println("El arreglo está ordenado de forma ascendente.");
            } else {
                System.out.println("El arreglo no está ordenado de forma ascendente.");
            }

            Integer elementos = 25;
            System.out.println("Secuencia de Fibonacci con "+ elementos+" elementos");
            System.out.println(getFibonacci(elementos));
        }
}
