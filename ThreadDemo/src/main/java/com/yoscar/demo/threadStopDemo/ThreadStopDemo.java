package com.yoscar.demo.threadStopDemo;

// 测试stop
// 不要使用stop或者destroy等jdk不建议使用的方法来停止线程
// 使用标志位 来停止线程或让线程正常停止
public class ThreadStopDemo implements Runnable {

    //1.设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run....Thread" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStopDemo thread = new ThreadStopDemo();

        new Thread(thread).start();

        for (int i = 0; i < 10000; i++) {
            if (i == 9000) {
                // 调用内部的stop方法停止线程
                thread.stop();
                System.out.println("该线程停止了");
            }
        }
    }
}
