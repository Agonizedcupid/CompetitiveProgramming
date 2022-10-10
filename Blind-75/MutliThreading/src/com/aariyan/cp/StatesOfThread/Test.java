package com.aariyan.cp.StatesOfThread;

public class Test implements Runnable {
    public static Test obj;
    public static Thread threadOne;

    public static void main (String[] args) {
        obj = new Test();

        //TODO : NEW STATE
        threadOne = new Thread(obj); //Thread One is created & It's on the new state:
        System.out.println("State of Thread One after creating it: "+threadOne.getState());

        //TODO: RUNNABLE STATE
        threadOne.start(); //Thread just run means ready to execute:
        System.out.println("State of thread after calling .Start() : "+threadOne.getState());
    }


    @Override
    public void run() {
        //Creating the instance of ThreadTest Class:
        ThreadState threadState = new ThreadState(); // It's now in New State
        //TODO: NEW STATE
        Thread threadTwo = new Thread(threadState); // Thread two is created, and it's in the new state:
        System.out.println("State of thread two just after creating: "+threadTwo.getState());

        //TODO: RUNNABLE STATE
        threadTwo.start(); //Just started the threadTwo:
        System.out.println("State of thread two when moved to Runnable state: "+threadTwo.getState());

        //Moving Thread two to Timed Wait state:
        //TODO: TIMED WAITING
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
        System.out.println("State of thread two after calling .sleep() : "+threadTwo.getState());

        try {
            threadTwo.join(); // Waiting for threadTwo to die
        }catch(Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
        System.out.println("State of threadTwo after finishing execution: "+threadTwo.getState());
    }
}
