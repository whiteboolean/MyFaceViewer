package com.example.myfaceviewer.tryfinally;

public class Test {

    public static void main(String[] args) {

        try {
            System.out.println("你好吗");
//            return;
        } catch (Exception e) {
            System.out.println("我是catch");
            e.printStackTrace();
        } finally {
            System.out.println("我是finally");
        }
        System.out.println("我是finally外面的值");
    }
}
