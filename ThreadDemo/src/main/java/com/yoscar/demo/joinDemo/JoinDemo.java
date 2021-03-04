package com.yoscar.demo.joinDemo;

// 测试join方法，插队
public class JoinDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip线程来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinThread = new JoinDemo();
        Thread thread = new Thread(joinThread);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i == 200) {
                thread.join();
            }
            System.out.println("main" + i);

        }
    }
}
