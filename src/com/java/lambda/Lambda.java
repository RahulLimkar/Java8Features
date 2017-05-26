package com.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by a171535 on 21-04-2017.
 */
public class Lambda {
    public static void main(String[] a){
        List<String> names = Arrays.asList("Raj", "Adesh", "Satya", "Peter");
        // Before Lambda
        Collections.sort(names,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        System.out.println("called method");
                        return o1.compareTo(o2);
                    }
                });
        System.out.println(names);

        //After Lambda - Instead of creating long anonymous classes, Java 8 provide shorter syntax.

        Collections.sort(names, (String o1, String o2) -> {
            System.out.println("Calling method");
            return o1.compareTo(o2);
        });
        System.out.println(names);

        // Another shorter format - For one line method bodies you can skip both the braces '{}' and return keyword
        Collections.sort(names, (String o1, String o2) -> o1.compareTo(o2));
        System.out.println(names);

        // Another shorter format - Java compiler aware function parameter types so that can be skipped as well.
        Collections.sort(names, (o1, o2)-> o1.compareTo(o2));
        System.out.println(names);


    }

}
