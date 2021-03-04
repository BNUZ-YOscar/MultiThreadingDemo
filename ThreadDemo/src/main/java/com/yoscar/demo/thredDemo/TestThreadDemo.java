package com.yoscar.demo.thredDemo;

// Thread实现多线程
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
        // 如果使用run并不会new出子线程，而是等run方法执行完再继续执行主线程
        thread.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程执行" + i);
        }
    }

}
