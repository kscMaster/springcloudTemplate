package org.example.vo;

public enum Singleton {
     INSTANCE;
     public void businessMethod() {
          System.out.println("我是一个单例！");
     }
}
