package com.java.functionalinterface;

/**
 * Created by a171535 on 21-04-2017.
 */
@FunctionalInterface
public interface Converter<F, T> {
    /*Functional interface must contain exactly one abstract method declaration.
    Each lambda expression of that type will be matched to this abstract method.*/
    T convert(F from);
}
