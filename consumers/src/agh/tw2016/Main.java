package agh.tw2016;

public class Main {
    public static int cThreads = 50;
    public static int pThreads = 10;
    public static int size = 50;

    public static void main(String[] args) {
        PortionBuffer buf = new PortionBuffer(size);
        Monitor monitor = new Monitor(size);
        Thread producers[] = new Thread[pThreads];
        Thread consumers[] = new Thread[cThreads];
        for (int i = 0; i < cThreads; i++) {
            consumers[i] = new Thread(new Consument(monitor, buf));
            consumers[i].start();
        }
        for (int i = 0; i < pThreads; i++) {
            producers[i] = new Thread(new Producent(monitor, buf));
            producers[i].start();
        }
/*        for (int i = 0; i < cThreads; i++) {
            try {
                consumers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < pThreads; i++) {
            try {
                producers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
