package com.aariyan.cp.ExtendingThreadClass;

import com.aariyan.cp.Interface.ExtendInterface;

public class ExtendingThreadClass extends Thread{

    private String message;
    public ExtendingThreadClass(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Message: " + message + "\n" +
                "ID: " + Thread.currentThread().getId() + "\n" +
                "NAME: " + Thread.currentThread().getName());
    }

}
