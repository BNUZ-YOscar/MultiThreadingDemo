package com.yoscar.demo.sync;

// 两个人去银行取钱
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100, "yoscar");

        Drawing you = new Drawing(account, 50, "你");
        Drawing gf = new Drawing(account, 100, "gf");
        you.start();
        gf.start();
    }
}

// 账户
class Account {
    public int money; // 余额
    public String name; // 卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


class Drawing extends Thread {
    Account account;// 账户
    int drawingMoney; // 取钱数
    int nowMoney; // 手里有多少钱

    public Drawing(Account account, int drawingMoney, String name) {
        this.account = account;
        this.drawingMoney = drawingMoney;
        super.setName(name);
    }


    @Override
    public void run() {
        // 判断有没有钱
        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "银行卡余额不足");
            return;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 卡内余额 = 余额 - 取钱数
        account.money = account.money - drawingMoney;
        //手里的钱
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name + "余额为：" + account.money);
        System.out.println(this.getName() + "手里的钱：" + nowMoney);
    }
}