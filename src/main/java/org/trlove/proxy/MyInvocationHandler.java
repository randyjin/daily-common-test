package org.trlove.proxy;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * MyInvocationHandler
 *
 * @author 奕超
 * @date 2017/5/11
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy() throws ClassNotFoundException {
        return Proxy.newProxyInstance(Thread.currentThread()
                        .getContextClassLoader(), target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- before -----");
        Object result = method.invoke(target, args);
        System.out.println("----- after -----");
        return result;
    }
}
