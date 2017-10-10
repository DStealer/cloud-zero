package com.cloudzero.arch.other;

import org.testng.annotations.Test;

import java.util.concurrent.Exchanger;

/**
 * Created by lishiwu on 2016/10/11.
 */
public class TestExchanger {
    @Test(alwaysRun = true)
    public void testExchanger() throws Exception{
        Exchanger<Object> exchanger = new Exchanger<>();
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" before change ...");
                    exchanger.exchange(null);
                    System.out.println(Thread.currentThread().getName()+" after change ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println(Thread.currentThread().getName()+" before change ...");
        Object object = exchanger.exchange(null);
        System.out.println(object);
        System.out.println(Thread.currentThread().getName()+" after change ...");
        Thread.currentThread().join();
    }
}
