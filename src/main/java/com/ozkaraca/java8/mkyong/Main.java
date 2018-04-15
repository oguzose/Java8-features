package com.ozkaraca.java8.mkyong;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Main {
  public static void main(String[] args) {
    List<Integer> numberList = Arrays.asList(1,2,3,4,5);

    numberList.stream()
           .filter(n-> n %2 == 0)
           .forEach(System.out::println);
    
    
    List<String> lines = Arrays.asList("spring", "node", "mkyong");

    List<String> result = lines.stream()                // convert list to stream
            .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
            .collect(Collectors.toList());              // collect the output and convert streams to a List

    result.forEach(System.out::println);                //output : spring, node
    
  }
  
}