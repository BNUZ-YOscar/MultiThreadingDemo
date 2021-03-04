package com.yoscar.demo.sync;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {

    public static void main(String[] args) {
        final List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
