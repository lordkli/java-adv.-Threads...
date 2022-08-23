package com.threads;

public class Volatile {
    volatile public static int flag = 0;

    //if the thread depends on a variable, you have infinite loop risk. In order to prevent this risk
//    you need to use "volatile" keyword before the variable. D't forget to use volatile keyword.

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (flag == 0){
                        System.out.println("Thread 1 running");
                    }else {
                        break;
                    }
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag = 1;
                System.out.println("The value of flag is updated");
            }
        });
        thread2.start();
    }
}
