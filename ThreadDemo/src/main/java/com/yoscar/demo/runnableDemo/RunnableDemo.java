package com.yoscar.demo.runnableDemo;

// Runable实现多线程
public class RunnableDemo implements Runnable {

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程" + i);
        }
    }

    public static void main(String[] args) {

        RunnableDemo runnable = new RunnableDemo();
        new Thread(runnable).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程：" + i);
        }
    }

}
