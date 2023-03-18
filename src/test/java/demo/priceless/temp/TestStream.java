package com.temp;

import java.util.stream.Stream;

public class TestStream {

    // Getting a stream consisting of the elements having UpperCase Character at custom index say be it '1'
    // using Stream filter
    public void testStream(){
        Stream<String> stream = Stream.of(
                "Geeks", "fOr", "GEEKSQUIZ", "GeeksforGeeks");
                 stream
                .filter(
                        str -> Character.isUpperCase(str.charAt(1)))
                .forEach(System.out::println);

        stream.filter(str -> str.endsWith("s"))
                .forEach(System.out::println);
    }

    public static void main (String []args){
        TestStream ts = new TestStream();
        ts.testStream();
    }
}
