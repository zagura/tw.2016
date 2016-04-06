package agh.tw2016;

public class Main {
    public static int cThreads = 5;
    public static int portion = 10;
    public static void main(String[] args) {
        PortionBuffer buffer = new PortionBuffer(portion);
        Monitor monitor = new Monitor(buffer);
        Thread producers[] = new Thread[cThreads];
   //     Thread consumers[] = new Thread[cThreads];
        for (int i = 0; i < cThreads; i++) {
    //        consumers[i] = new Thread(new Consument(monitor));
            producers[i] = new Thread(new Producent(monitor));
            producers[i].start();
     //       consumers[i].start();
        }
        Consument c = new Consument(monitor);
        c.start();
        for (int i = 0; i < cThreads; i++) {
            try {
 //               consumers[i].join();
                producers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        c.join();
    }
}
