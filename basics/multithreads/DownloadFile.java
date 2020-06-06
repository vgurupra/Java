package com.company.basics.multithreads;

public class DownloadFile implements Runnable {
    private DownloadStatus status;
    public DownloadFile(DownloadStatus status){
        this.status = status;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10_00000; i++){
            status.incrementByte();
        }
        System.out.println("Done!!");
        status.done();

        synchronized (status){
            status.notify();
        }
    }

    public int getTotalBytesRead() {
        return status.getTotalBytes();
    }
}
