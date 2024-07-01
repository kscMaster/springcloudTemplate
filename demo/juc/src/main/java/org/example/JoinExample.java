package org.example;

/**
 * @content
 * 演示线程的join方法
 *
 */
public class JoinExample {
    
    public static void main (String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
    
    public void test() {
        MethodA a = new MethodA();
        MethodB b = new MethodB(a);
        b.start();
        a.start();
    }
    
    private class MethodA extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A");
        }
    }

    private class MethodB extends Thread {
        private MethodA a;
        MethodB(MethodA a) {
            this.a = a;
        }
        @Override
        public void run() {
            try {
                a.join();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }
}