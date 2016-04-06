package agh.tw2016;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by student10 on 2016-03-31.
 */
public class Consument extends Thread implements Runnable {
    private final Monitor m;
    private Random r;
    public Consument(Monitor m){
        super();
        this.m = m;
        this.r = new Random();
    }
    public void run() {
        while (true) {

            m.read(getId());
            try {
                sleep(r.nextInt(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
