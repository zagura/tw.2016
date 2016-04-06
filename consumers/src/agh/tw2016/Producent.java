package agh.tw2016;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by student10 on 2016-03-31.
 */
public class Producent extends Thread implements Runnable{
    private final Monitor m;
    private Random r;
    private PortionBuffer buffer;
    public Producent(Monitor m, PortionBuffer buff){
        super();
        this.m = m;
        r = new Random();
        buffer = buff;
    }



    public void run(){
        while(true){
            int index = m.increment();
            buffer.insert(getId(), index);
            m.confirm(index);
            try {
                sleep(r.nextInt(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
