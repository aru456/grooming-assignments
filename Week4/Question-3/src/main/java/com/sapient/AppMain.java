package com.sapient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=30;i++){
            list.add(i);
        }
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()->{

            int sum=0;
            for(int i=0;i<10;i++){
                sum+= list.get(i);
            }
            return sum;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()->{

            int sum1=0;
            for(int i=10;i<20;i++){
                sum1+= list.get(i);
            }
            return sum1;
        });
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(()->{
            int sum1=0;
            for(int i=20;i<30;i++){
                sum1+= list.get(i);
            }
            return sum1;
        });

        CompletableFuture.allOf(future1,future2,future3).thenAccept(v -> {
           List<Integer> threeTasksSum = Stream.of(future1,future2,future3).map(CompletableFuture::join).collect(Collectors.toList());
           System.out.println("The three sums are :" + threeTasksSum);
           System.out.println("Sum of the three combined is : "+ threeTasksSum.stream().reduce(0,Integer::sum));
        });

    }
}
