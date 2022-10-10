package com.aariyan.cp.StatesOfThread;

public class ThreadState implements Runnable{

    @Override
    public void run() {
        //Moving thread 2 to TIMED WAITING state:
        try {
            Thread.sleep(1500);
        } catch(Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
        System.out.println("State of thread-1 while it called join() in Thread-2 : "+Test.threadOne.getState());

        try {
            Thread.sleep(200);
        }catch(Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}

