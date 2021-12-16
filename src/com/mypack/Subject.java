package com.mypack;

import java.util.ArrayList;

public class Subject {
    private  ArrayList<Observer> observers = new ArrayList<>();
    private int state;
    public int getState(){
        return state;
    }
    public void setState(int state){
        this.state = state;
        notifyAllobservers();
    }
    public void attach(Observer observer ){
        observers.add(observer);
    }
    public void notifyAllobservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
