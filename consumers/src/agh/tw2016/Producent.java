package agh.tw2016;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by student10 on 2016-03-31.
 */
public class Producent extends Thread implements Runnable{
    private final Monitor m;
    private Random r;
    public Producent(Monitor m){
        super();
        this.m = m;
        r = new Random();
    }



    public void run(){
        while(true){
            m.increment(getId());
            try {
                sleep(r.nextInt(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
