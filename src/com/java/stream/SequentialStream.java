package com.java.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.lang.Object







/**
 * Created by a171535 on 25-04-2017.
 */
public class SequentialStream {

    public static void main(String[] a){
        Collection<String>  sl = Arrays.asList("India", "China", "US","Armenia", "Sri Lanka","Indonesia","Uk");

        // Filter accepts predicate(boolean valued function) to filter all elements of the stream.
        sl.stream().filter((s) -> s.startsWith("U")).forEach(System.out::println);

        //Sorted is an intermediate operation which returns sorted view of stream. Elements are sorted in
        // natural order unless you pass custom Comparator
        sl.stream().sorted().forEach(System.out::println);

        // Map - intermediate operation converts each element into another object via given function.

        sl.stream().map(String::toUpperCase).sorted((x,b) -> b.compareTo(x)).forEach(System.out::print);

        //Matching operation - checks whether a predicate matches the stream.
        // All those operation are terminal and return the boolean result.

        boolean anystartWithS = sl.stream().anyMatch(s -> s.startsWith("S"));
        System.out.println("Is stream contain elements start with 'S' " +anystartWithS);
        boolean allstartwithS = sl.stream().allMatch(s -> s.startsWith("S"));
        System.out.println("All stream elements start with 'S' " +anystartWithS);
        boolean nonMatchsWithZ=sl.stream().noneMatch(s->s.startsWith("Z"));
        System.out.println("No matching 'Z' start " +nonMatchsWithZ);

        // Reduce - JDK provides general purpose reduction operation using Stream.reduce and Stream.collect methods.
        // Stream.reduce  is general purpose reduction operation. Reduce operation return always single result.

        Optional<String> reduced = sl.stream().sorted().reduce((s1, s2) -> s1 + "#"+s2);
        reduced.ifPresent(System.out::println);

        // e.g. Apply 12% VAT on each purchase  and bill total
        //Traditional way
        List<Integer> costBeforeTax = Arrays.asList(100,150,1100,200);
        double total = 0.0d;
        for(Integer cost : costBeforeTax){
            total +=(cost + 0.12*cost);
        }
        System.out.println("Total bill "+total);
        // Lambda way
        double lamdatotal = costBeforeTax.stream().map(cost -> cost + 0.12*cost).reduce((r,c)-> r+c).get();
        System.out.println("Lamda Total bill "+lamdatotal);
        // Using map you can transform data and use that for further processing
        String s = costBeforeTax.stream()
                .map(cost -> cost + 0.12*cost)
                .map(cost -> String.valueOf(cost.doubleValue()))
                .reduce((r,c)-> r + c).get();
        System.out.println(s);






    }
}
