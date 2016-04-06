package agh.tw2016;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by student10 on 2016-03-31.
 */
public class Consument extends Thread implements Runnable {
    private final Monitor m;
    private Random r;
    private PortionBuffer buffer;
    public Consument(Monitor m, PortionBuffer buff){
        super();
        this.m = m;
        this.r = new Random();
        this.buffer = buff;
    }
    public void run() {
        while (true) {

            int index = m.read();
            buffer.take(index);
            m.freeIt(index);
            try {
                sleep(r.nextInt(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
