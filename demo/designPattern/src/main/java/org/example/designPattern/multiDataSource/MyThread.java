package org.example.designPattern.multiDataSource;

class MyThread extends Thread {
    private String name;
    public MyThread(String mName) {
        this.name = mName;
    }
    @Override
    public void run() {
        super.run();
        try {
            System.out.println(name + "开始等待");
            sleep(2000);
            System.out.println(name + "开始完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t1.join();
        t2.start();
    }
}