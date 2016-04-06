package agh.tw2016;

import java.util.*;

/**
 * Created by student10 on 2016-03-31.
 */
public class Monitor {
    private int bufor;
    private final int size = 2*Main.portion;
    boolean busy;
    private Random r;
    public synchronized void increment(long id){
        while(busy || bufor >= size){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = true;
        int m = Main.portion;
        if(size - bufor < m) m = size - bufor;
        m--;
        if(m > 0){
            bufor += r.nextInt(m) +1;
        }else{
            bufor++;
        }
        System.out.println("ID: " + id + " add\t" + bufor);
        busy = false;
        notify();
    }
    public synchronized void read(long id){
        while(busy || bufor <= 0){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer signaled");
        busy = true;
        int m = Main.portion;
        if(bufor < m) m = bufor;
        m--;
        if(m > 0){
            bufor += r.nextInt(m) +1;
        }else{
            bufor++;
        }
        System.out.println("ID: " + id + " consume\t" + bufor);
        busy = false;
        notify();
    }
}
