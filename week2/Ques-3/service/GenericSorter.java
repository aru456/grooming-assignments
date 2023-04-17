package org.example.service;

import java.util.Arrays;


public class GenericSorter {
     public static <Type> Type[] genSort(Type[] arr){
        Arrays.sort(arr);
        return arr;
    }

}
