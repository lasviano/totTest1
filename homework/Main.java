package com.glodon.homework;

public class Main {
    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest();
        Test test = (Test) proxyTest.getTarget(new TestImpl());

        test.fun1();
        System.out.println();
        test.fun2();
        System.out.println();
        test.fun3();
        System.out.println();
        test.fun4();
    }
}