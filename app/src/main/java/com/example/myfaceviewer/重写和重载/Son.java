package com.example.myfaceviewer.重写和重载;

public class Son  extends Parent{

    @Override
    protected void parent() {
        super.parent();
        System.out.println("我是儿子");
    }
}
