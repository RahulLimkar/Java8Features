package com.java.methodconstructref;

/**
 * Created by a171535 on 24-04-2017.
 */
public interface PersonFactory<P extends Person> {

    P create(String fn, String ln);

}
