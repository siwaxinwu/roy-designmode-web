package com.roy.service.javaobservermode;

import java.util.Observable;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 17:14
 */
public class ConcreteSubject extends Observable {

    public void change() {
        setChanged();
        this.notifyObservers();
    }
}
