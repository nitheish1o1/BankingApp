package com.mypack;

public class Message_observer extends Observer {
    public Message_observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        int state = subject.getState();
        if(state<0){
            System.out.printf("message notification debeted RS %d\n", (state*-1));
        }
        else {
            System.out.printf("message notification credited RS %d\n", state);
        }
    }
}
