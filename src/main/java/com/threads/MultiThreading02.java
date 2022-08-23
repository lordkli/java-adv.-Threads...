package com.threads;

public class MultiThreading02 {

    public static int counter = 0;

//    if you use a single data for different threads, you have to synchronize the method otherwise you will
//    get different result for each execution. to synchronize a method use "synchronized" keyword before the access modifier

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread1 is completed...");
            }
        });
        thread1.start();

//        thread1.join();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 is completed...");
            }
        });
        thread2.start();
    }
}

class Counter{
    synchronized public static void count(){
        for (int i = 1; i<=1000; i++){
            MultiThreading02.counter++;
        }
        System.out.println("Counter: " + MultiThreading02.counter);
    }
}
