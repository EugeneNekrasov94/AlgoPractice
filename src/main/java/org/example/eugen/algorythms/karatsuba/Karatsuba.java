package org.example.eugen.algorythms.karatsuba;

import static java.lang.Integer.*;

//алгоритм рекурсивного умножения
public class Karatsuba {
    public static void main(String[] args) {
        System.out.println(getResult(12,34));
        System.out.println(factorial(5));
    }
    static int getResult(Integer x,Integer y) {
        int n = x.toString().length();
        if (n == 1) {
            return x * y;
        } else {
            int a = parseInt(x.toString().substring(0,x.toString().length()/2));
            int b = parseInt(x.toString().substring(x.toString().length()/2));
            int c = parseInt(y.toString().substring(0,y.toString().length()/2));
            int d = parseInt(y.toString().substring(y.toString().length()/2));
            int p = a + b; int q = c + d;
            getResult(a,c);
            getResult(b,d);
            getResult(p,q);
            int adbc = p*q - a * c - b * d;
            return (int) (Math.pow(10,n) * a * c + Math.pow(10,n/2) * adbc + b*d);
        }
    }

    static int factorial(int x) {
        if (x == 1) {
            return 1;
        }
        return factorial(x-1) * x;
    }
}
