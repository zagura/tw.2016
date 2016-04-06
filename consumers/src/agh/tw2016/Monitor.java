package agh.tw2016;

import java.util.*;

/**
 * Created by student10 on 2016-03-31.
 */
public class Monitor {
    boolean busy;
    boolean busy2;
    private Random r;
    int index;
    private final PortionBuffer buffer;
    public Monitor(PortionBuffer buffer){
        busy = false;
        busy2 = false;
        r = new Random();
        this.buffer = buffer;
    }
    public synchronized void increment(long id){
        while(busy2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy2 = true;
        index++;
        int i = index;
        busy = true;
        notifyAll();
        busy2 = false;
        buffer.insert(id, i);
        busy = false;
        notifyAll();
    }
    public synchronized void read(long id){
        while(busy || index < 0){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = true;
        index = buffer.take(index);
        busy = false;
        notifyAll();
    }
}
