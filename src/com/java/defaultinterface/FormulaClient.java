package com.java.defaultinterface;

/**
 * Created by a171535 on 21-04-2017.
 */
public class FormulaClient {
    public static void main(String[] a){
        Formula f = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 10);
            }
        };

        System.out.println(f.calculate(10));
        System.out.println(f.sqrt(16));
    }
}
