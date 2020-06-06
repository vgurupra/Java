package com.company.basics.multithreads;

import java.time.Duration;

public class LongTask {
    public static void simulate(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
