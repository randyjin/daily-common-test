package org.trlove.design.pattern.proxy;

/**
 * Created by aguda on 16/6/5.
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void operate() {
        System.out.println("before");
        subject.operate();
        System.out.println("after");
    }
}
