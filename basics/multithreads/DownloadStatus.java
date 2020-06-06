package com.company.basics.multithreads;

public class DownloadStatus {
    private int totalBytes;
    private boolean done;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementByte() {
        totalBytes++;
    }

    public boolean isDone(){
        return done;
    }

    public void done(){
        done = true;
    }
}
