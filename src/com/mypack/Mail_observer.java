package com.mypack;

public class Mail_observer extends Observer {
    public Mail_observer (Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        int state = subject.getState();
        if(state<0){
            System.out.printf("mail notification debeted RS %d\n", (state*-1));
        }
        else {
            System.out.printf("mail notification credited RS %d\n", state);
        }
    }
}
