package com.glodon.homework;

public class TransactionAspect implements Aspect {
    @Override
    public void before() {
        System.out.println("事务开始前");
    }

    @Override
    public void after() {
        System.out.println("事务结束");
    }
}
