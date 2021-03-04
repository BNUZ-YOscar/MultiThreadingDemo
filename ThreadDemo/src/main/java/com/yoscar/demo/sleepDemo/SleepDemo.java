package com.yoscar.demo.sleepDemo;

// 多个线程同时操作同一个对象
// 买火车票出现了线程不安全问题，待解决

public class SleepDemo implements Runnable {

    private static int ticketNums = 10;

    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        SleepDemo tick = new SleepDemo();
        new Thread(tick, "小明").start();
        new Thread(tick, "老师").start();
        new Thread(tick, "黄牛").start();
    }
}
