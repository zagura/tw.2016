package agh.tw2016;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * tw.2016
 * Created by Michał Zagórski on 07.04.16.
 */
public class PortionBuffer {
    private long[] buffer;
    private final int size;
    private Random r;
    public PortionBuffer(int size){
        this.size = size;
        buffer = new long[size];
        r = new Random();
    }
    public int getSize(){
        return this.size;
    }
    public void insert(long val, int index){
        buffer[index] = val;
        System.out.println("ID: " + val + " add\t" + index);
        try {
            sleep(r.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int take(int index){
        long res = buffer[index];
        buffer[index] = 0;
        System.out.println("ID: " + res + " consume\t" + index);
        try {
            sleep(r.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return index;
    }
}