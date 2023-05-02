package com.sapient;

import java.util.concurrent.RecursiveTask;

public class TaskFork extends RecursiveTask<Integer> {
    private int first;
    private int last;

    public TaskFork(int first,int last){
        this.first = first;
        this.last = last;

    }

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread());
        if(last-first < 100){
            return CountDigits();
        }

            int mid = first + (last-first)/2;
            TaskFork t1 = new TaskFork(first,mid);
            TaskFork t2 = new TaskFork(mid+1,last);
            t1.fork();
            t2.fork();
            return t1.join()+t2.join();


    }
    public Integer CountDigits(){
        int count =0;
        for (int i=first;i<=last;i++){
            String p = Integer.toString(i);
            if(p.contains("9")){
                count++;
                System.out.println(i + " ---- "+p);
            }
        }
        return count;
    }
}
