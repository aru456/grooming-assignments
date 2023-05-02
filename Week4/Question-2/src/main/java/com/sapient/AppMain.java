package com.sapient;

import java.util.concurrent.ForkJoinPool;

public class AppMain {
    public static void main(String[] args) {

        ForkJoinPool pool = ForkJoinPool.commonPool();
        TaskFork taskFork = new TaskFork(1,1000);
        int result = pool.invoke(taskFork);

        System.out.println("No of numbers that contain 9 are = " + result);


    }

}
