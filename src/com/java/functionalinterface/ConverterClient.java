package com.java.functionalinterface;

import com.java.methodconstructref.Person;

import java.util.function.*;

/**
 * Created by a171535 on 21-04-2017.
 */
public class ConverterClient {

    public static void main(String[] s){


        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer r = converter.convert("1122");
        System.out.println("StringToInteger " +r);

        Converter<Double, Double> tempconverter = (from) -> { Double v = from * 33.8; return Math.ceil(v);};
        Double f = tempconverter.convert(11.0);
        System.out.println(f);

        // Utilizing static method references

        Converter<String, Integer> sc = Integer::valueOf;
        System.out.println(sc.convert("10"));
    }


}
