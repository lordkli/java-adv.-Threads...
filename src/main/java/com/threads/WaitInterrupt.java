package com.threads;

public class WaitInterrupt {
        static public int balance = 0;

        public static void main(String[] args) {
            WaitInterrupt obj = new WaitInterrupt();
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    obj.withdraw(800);

                }
            });

            thread1.setName("Withdraw Thread");
            thread1.start();

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    obj.deposit(2000);
                    thread1.interrupt();
                }
            });

            thread2.setName("Deposit Thread");
            thread2.start();

        }
        public void withdraw(int amount){
            synchronized (this){

                if (balance<=0 || balance < amount){
                    System.out.println("Waiting for the amount to update");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted catch block executed");
                        balance = balance-amount;
                        System.out.println("Withdrawal is successfully. The current balance is " + balance);                    }
                }
            }

        }

        public void deposit(int amount){
            balance = balance + amount;
            System.out.println("The amount is deposited. The current balance is " + balance);




        }
    }


