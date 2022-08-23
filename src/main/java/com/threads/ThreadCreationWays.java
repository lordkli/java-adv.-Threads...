package com.threads;

import jdk.swing.interop.SwingInterOpUtils;

public class ThreadCreationWays {
    public static void main(String[] args) {
//  1.Way extending Thread
        MyThread thread1 = new MyThread();
        thread1.setName("Thread 1");

//        if you call the run method you just call the run method not start the thread
//        thread1.run();
        thread1.start();

//  2:Way is implements Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

//  3.Way uses anonymous structure based on interface
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread created with the anonymous way");
            }
        });

        thread3.start();

        Thread thread4 = new Thread(){
            @Override
            public void run() {
                System.out.println("Class Based anonymous example");
            }
        };
        thread4.start();

        Thread thread5 = new Thread(()->{
            System.out.println("Thread is created with lambda exp.");
        });
        thread5.start();

    }
}


class MyThread extends Thread{
    @Override
    public void run() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("It is custom thread");
    }

}
class MyRunnable implements Runnable{

    @Override
    public void run() {

        System.out.println("It is custom runnable that is implemented from Runnable Interface");
    }
}
