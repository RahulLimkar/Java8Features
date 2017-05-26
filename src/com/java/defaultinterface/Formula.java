package com.java.defaultinterface;

/**
 * Created by a171535 on 21-04-2017.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
