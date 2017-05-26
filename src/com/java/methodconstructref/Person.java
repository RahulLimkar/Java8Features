package com.java.methodconstructref;

/**
 * Created by a171535 on 24-04-2017.
 */
public class Person {

    String fn;
    String ln;

    public Person(){

    }

    public Person(String fn, String ln){
        this.fn = fn;
        this.ln = ln;
    }

    public String getFn(){
        return fn;
    }
}
