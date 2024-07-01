package org.example;

import cn.hutool.core.util.StrUtil;

import java.util.concurrent.TimeUnit;

// volatail的用法，没有加volatile的时候，Thread-A线程不会停止

public class TestVolatile {

    private volatile static boolean  stop = false;

    public static void main(String[] args) {
        // Thread-A
        new Thread("Thread A") {
            @Override
            public void run() {
                while (!stop) {
                }
                StrUtil.builder().append("a").toString();
                System.out.println(Thread.currentThread() + " stopped");
            }
        }.start();

        // Thread-main
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread() + " after 1 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
    }
}