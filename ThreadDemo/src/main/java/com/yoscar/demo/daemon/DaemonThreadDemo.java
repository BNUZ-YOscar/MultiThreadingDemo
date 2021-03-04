package com.yoscar.demo.daemon;

// 线程分为用户线程和守护线程
// 虚拟机必须确保用户线程执行完毕，不用等待守护线程
// 常见守护线程有操作日志、监控日志和垃圾回收
public class DaemonThreadDemo {


    public static void main(String[] args) {
        God godThread = new God();
        You youThread = new You();
        Thread thread = new Thread(godThread);
        thread.setDaemon(true);// 默认为false，代表用户线程
        thread.start();// 启动上帝线程

        new Thread(youThread).start();// 启动用户线程
    }
}


class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("god bless you");
        }
    }
}

class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("alive");
        }
        System.out.println("dead");
    }
}
