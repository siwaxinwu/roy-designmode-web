package com.roy.service.javaobservermode;

import java.util.Observable;
import java.util.Observer;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 17:14
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("接收到更新");
    }
}