package agh.tw2016;

public class Main {
    public static int cThreads = 10;
    public static int portion = 10;
    public static void main(String[] args) {

        Monitor monitor = new Monitor();
        Thread producers[] = new Thread[cThreads];
        Thread consumers[] = new Thread[cThreads];
        for (int i = 0; i < cThreads; i++) {
            consumers[i] = new Thread(new Consument(monitor));
            producers[i] = new Thread(new Producent(monitor));
            producers[i].start();
            consumers[i].start();
        }
        for (int i = 0; i < cThreads; i++) {
            try {
                consumers[i].join();
                producers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
