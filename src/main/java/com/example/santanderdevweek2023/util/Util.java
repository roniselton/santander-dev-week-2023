package com.example.santanderdevweek2023.util;

public class Util {

    private static int numConta = 1;

    public static String gerarProximoNumeroConta(){
        int numero = numConta++;
        return "1000"+  numero + "-" + (numero% 2==0? 1 :0 );
    }

    public static String gerarProximoNumeroCartao(){
        int base = numConta++;
        int numero = ( base % 10) ;
        return "1111 "+ (base+1234)  +" 4321 " + numero+numero+numero+numero ;
    }

}
