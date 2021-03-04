package com.yoscar.demo.runnableDemo;

public class Race implements Runnable {

    private static String winner;

    public void run() {
        for (int i = 0; i <= 100; i++) {

            // 判断比赛是否结束
            boolean flag = gameOver(i);

            // 比赛结束停止程序
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
