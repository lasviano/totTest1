package com.glodon.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest implements InvocationHandler {

    private Object target;

    public Object getTarget(Test test){
        target = test;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method fun = target.getClass().getMethod(method.getName());
//        Transaction annotation = fun.getAnnotation(Transaction.class);
        if (fun.isAnnotationPresent(Log.class)){
            new LogAspect().before();
        }
        if (fun.isAnnotationPresent(Transaction.class)){
            new TransactionAspect().before();
        }

        method.invoke(target,args);

        if (fun.isAnnotationPresent(Log.class)){
            new LogAspect().after();
        }
        if (fun.isAnnotationPresent(Transaction.class)){
            new TransactionAspect().after();
        }
        return null;
    }
}
