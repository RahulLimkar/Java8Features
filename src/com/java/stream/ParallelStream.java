package com.java.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by a171535 on 27-04-2017.
 */
public class ParallelStream {

    public static void main(String[] ar){
        // Create data
        int max = 1000000;
        List<String> ls = new ArrayList<>();
        for(int i = 0; i< max ; i++){
            UUID u = UUID.randomUUID();
            ls.add(u.toString());
        }

        //Sort using sequential approach.
        long t0 = System.nanoTime();
        long count = ls.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        System.out.println(String.format("Total time for sequential execution %s milliseconds.",
                TimeUnit.NANOSECONDS.toMillis(t1-t0)));
        // Sort using parallel approach.
        long t2 = System.nanoTime();
        long count1 = ls.parallelStream().sorted().count();
        long t3 = System.nanoTime();
        System.out.println(String.format("Total time for parallel execution %s milliseconds.",
                TimeUnit.NANOSECONDS.toMillis(t3-t2)));




    }
}
