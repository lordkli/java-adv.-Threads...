package com.threads;

public class MultiThreading01 {
    public static void main(String[] args) throws InterruptedException {


        System.out.println("Current Thread:"+ Thread.currentThread().getName());   //main


        long startTime = System.currentTimeMillis();

        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread(2);

        counter1.countMe();

        System.out.println("--------------------------------------");

        counter2.countMe();

        long endTime = System.currentTimeMillis();

        System.out.println("WithoutMultiThread Elapsed Time:" + (endTime-startTime) );  //main


        System.out.println("********************************************************************");

        long startTime4 = System.currentTimeMillis();

        CounterWithMultiThread counter3 = new CounterWithMultiThread(1);
        CounterWithMultiThread counter4 = new CounterWithMultiThread(2);

        counter3.start();

        System.out.println("--------------------------------------");

        counter4.start();


//        try {
//            Thread.sleep(120);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        //Waits for this thread to die.
        counter3.join();
        counter4.join();
        long endTime4 = System.currentTimeMillis();

        System.out.println("WithMultiThread Elapsed Time:" + (endTime4-startTime4) );
    }
}

class CounterWithoutMultiThread{
    private int threadNum;

    public CounterWithoutMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    public void countMe(){

        System.out.println("Current Thread--CounterWithoutMultiThread:"+ Thread.currentThread().getName());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 1; i < 10; i++) {

            System.out.println("i" + i + "Thread number:" +threadNum);

        }
    }
}

class CounterWithMultiThread extends Thread{
    private int threadNum;

    public CounterWithMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        countMe();
    }

    public void countMe(){

        System.out.println("Current Thread--CounterWithMultiThread:"+ Thread.currentThread().getName());//Thread-0, Thread-1

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 1; i < 10; i++) {

            System.out.println("i" + i + "Thread number:" +threadNum);

        }
    }
}