package com.yoscar.demo.sync;

// 不安全买票
// 线程不安全，超卖了
public class UnsafeDemo {

    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station, "aaa").start();
        new Thread(station, "bbb").start();
        new Thread(station, "ccc").start();
    }

}

class BuyTicket implements Runnable {

    private int tickNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        // 买票
        while (flag) {
            buy();
        }
    }

    private synchronized void buy() {
        if (tickNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "拿到" + tickNums--);
    }
}
