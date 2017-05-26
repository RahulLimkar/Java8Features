package com.java.stream;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by a171535 on 04-05-2017.
 */
public class FileOperation {

    public static void main(String[] ar) throws IOException {
        // Read all lines from file and find longest line from it.

        // 1. Using traditional
        String filename =  System.getProperty("user.dir") + "\\src\\com\\java\\stream\\company.txt";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        usingTraditionalLoop(br);
        br.close();
        // 2. Using recursion
        BufferedReader rb = new BufferedReader(new FileReader(filename));
        String re = usingRecursion("",rb);
        System.out.println("Using recursion : "+re);
        rb.close();
        // 3. Using Reduce function of stream api.  Thread safe
        BufferedReader b = new BufferedReader(new FileReader(filename));
        String r = b.lines().reduce((x,y) -> x.length() < y.length() ? y : x).get();
        System.out.println("Using Reduce function : "+ r);
        b.close();
        // 4. Using max function of stream api parallel processing. Thread-safe
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        String rs = bf.lines().parallel().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Using Max function comparator : " +rs);
        bf.close();
    }

    private static String usingRecursion(String longest, BufferedReader br) throws IOException {
        String l = br.readLine();
        if(l == null){
            return longest;
        }
        if(l.length() > longest.length()){
            longest = l;
        }
        return usingRecursion(longest,br);
    }

    private static void usingTraditionalLoop(BufferedReader br) throws IOException {
        String longest = "";
        boolean dataAvail = true;
        while(dataAvail) {
            String s = br.readLine();
            if(s == null) {
                dataAvail = false;
                break;
            }
            if(s.length() > longest.length())
                longest = s;
        }
        System.out.println("Using loop : " + longest);
    }
}
