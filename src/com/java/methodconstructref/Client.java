package com.java.methodconstructref;

import com.java.functionalinterface.Converter;

/**
 * Created by a171535 on 24-04-2017.
 */
public class Client {
    public static void main(String[] s) {
        StringOperation so = new StringOperation();
        // Using Java :: operator method references can be be passed to function
        Converter<String, String> sc = so::toUpperCase;
        System.out.println(sc.convert("My hobby"));

        //Using Java :: operator class constructor references can be be passed to function
        PersonFactory<Person> pf = Person::new;
        Person p = pf.create("First","Last");
        System.out.println("Person created successfully: "+p.getFn());

    }
}
