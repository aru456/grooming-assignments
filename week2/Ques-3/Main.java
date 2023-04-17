package org.example;

import org.example.service.GenericSorter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {32,53,54,31,92,1};
        System.out.println("Before sorting an IntegerArray: "  + Arrays.toString(arr));
        System.out.println("After sorting an IntegerArray: " + Arrays.toString(GenericSorter.genSort(arr)));

        Character[] chararr = {'a','d','c','z','h'};
        System.out.println("Before sorting an CharacterArray: " + Arrays.toString(chararr));
        System.out.println("After sorting the CharacterArray: " + Arrays.toString(GenericSorter.genSort(chararr)));
        }
}