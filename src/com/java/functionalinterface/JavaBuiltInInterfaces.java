package com.java.functionalinterface;

import com.java.methodconstructref.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Created by a171535 on 25-04-2017.
 */
public class JavaBuiltInInterfaces {
    public static void main(String[] s){
        biConsumerInterface();
        functionInterface();
        supplierInterface();
        consumerInterface();
        predicateInterface();
    }

    private static void consumerInterface() {
        // Consumer operation to be performed on single argument.
        Consumer<String> c = s -> System.out.println(s);
        c.accept("My Hard coded string");
        Consumer<Person> cp = po -> System.out.println("Hello " + po.getFn());
        cp.accept(new Person("harry","Potter"));
    }

    private static void supplierInterface() {
        // Supplier produce a result of given generic type.
        Supplier<Person> ps = Person::new;
        Person p = ps.get();
        IntSupplier is = () -> 10;
        System.out.println("int supplier returns "+is.getAsInt());
    }

    private static void functionInterface() {
        // Function interface of Java
        // 1. define function to convert string in quoted string
        Function<String, String> quote = s -> "'"+s+"'";
        // 2. Define function to convert integer to string.
        Function<Integer,String> intoString = Object::toString;

        //3. Define function to call quote and intoString function in sequence. First intoString function
        //   executed then quote function executed.
        Function<Integer,String> intoquote = quote.compose(intoString);
        System.out.println(intoquote.apply(4));
    }

    private static void biConsumerInterface() {
        BiConsumer<String, String> con = (a, b) -> {System.out.println(a + b);};
        con.accept("String", "Concat");
    }

    private static void predicateInterface(){

        Predicate<String> startWithA = s -> s.startsWith("A");
        Predicate<String>  fourLetterLong = s -> s.length() > 4;
        List<String> names = Arrays.asList("Peter","Aadharsh","Adams","Lokesh","Oliver");
        names.stream()
                .filter(startWithA.and(fourLetterLong))
                .forEach((n) -> System.out.println("Names starts" +
                " with A and having length more than 4 :" +n));
        names.stream()
                .filter(startWithA.or(fourLetterLong))
                .forEach((n) -> System.out.println("Names starts" +
                        " with A or having length more than 4 :" +n));

    }
}
