package com.yoscar.demo;

public class TestThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("执行多线程" + i);
        }
    }

    public static void main(String[] args) {
        TestThreadDemo thread = new TestThreadDemo();

        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程执行" + i);
        }
    }

}
