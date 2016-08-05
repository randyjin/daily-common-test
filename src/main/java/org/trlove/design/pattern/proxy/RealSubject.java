package org.trlove.design.pattern.proxy;

/**
 * Created by aguda on 16/6/5.
 */
public class RealSubject implements Subject {

    @Override
    public void operate() {
        System.out.println("real operate");
    }
}
