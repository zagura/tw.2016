package agh.tw2016;

import java.util.*;

/**
 * Created by student10 on 2016-03-31.
 */
public class Monitor {
    private final int size;
    boolean completed[];
    boolean free[];
    private int insert_index;
    private int read_index;
    private int count;
    boolean busy;
    private Random r;
    public Monitor(int size){
        busy = false;
        this.size = size;
        r = new Random();
        count = 0;
        read_index = 0;
        insert_index = 0;
        free = new boolean[size];
        completed = new boolean[size];
        for(int i = 0; i < size; i++){
            free[i] = true;
            completed[i] = false;
        }
    }
    public synchronized int increment(){
        while(busy || !free[insert_index]){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = true;
        insert_index++;
        int index = insert_index - 1;
        free[index] = false;
        insert_index %= size;
        busy = false;
        notifyAll();
        return index;
    }
    public synchronized int read(){
        while(busy || !completed[read_index] ){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        busy = true;
        int index = read_index;
        read_index++;
        read_index %= size;
        busy = false;
        notifyAll();
        return index;
    }
    public synchronized void confirm(int index){
        while(busy){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        busy = true;
        completed[index] = true;
        busy = false;
        notifyAll();
    }
    public synchronized void freeIt(int index){
        while(busy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        busy = true;
        free[index] = true;
        completed[index] = false;
        busy = false;
        notifyAll();
    }
}
