package com.glodon.homework;

public class TestImpl implements Test {

    @Transaction
    @Override
    public void fun1() {
        System.out.println("fun1");
    }

    @Log
    @Override
    public void fun2() {
        System.out.println("fun2");
    }

    @Transaction
    @Log
    @Override
    public void fun3() {
        System.out.println("fun3");
    }

    @Override
    public void fun4() {
        System.out.println("fun4");
    }
}
