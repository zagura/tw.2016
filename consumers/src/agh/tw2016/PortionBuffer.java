package agh.tw2016;

import static java.lang.Thread.sleep;

/**
 * tw.2016
 * Created by Michał Zagórski on 07.04.16.
 */
public class PortionBuffer {
    private long[] buffer;
    private final int size;
    public PortionBuffer(int size){
        this.size = size;
        buffer = new long[size];
    }

    public void insert(long val, int index){
        if(index < size){
            buffer[index] = val;
            index++;
        }
        System.out.println("ID: " + val + " add\t" + index);
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int take(int index){
        if(index >= size) index = size-1;
        long res = buffer[index];
        buffer[index] = 0;
        index--;
        System.out.println("ID: " + res + " consume\t" + index);
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return index;
    }
}
