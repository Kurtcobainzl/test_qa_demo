package algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class ShengChanZhe {
    private final int MAX = 6;
    AtomicInteger baozi = new AtomicInteger(0);

    public void produce() {
        synchronized (baozi) {
            while (baozi.get() >= MAX) {
                try {
                    baozi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            baozi.incrementAndGet();
            System.out.println("produce生产一个包子，当前共" + baozi.get() + "个," + Thread.currentThread().getId());
        }
    }

    public void consume() {
        synchronized (baozi) {
            while (baozi.get() <= 0) {
                try {
                    baozi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            baozi.decrementAndGet();
            System.out.println("consume消费一个包子，当前共" + baozi.get() + "个," + Thread.currentThread().getId());

        }
    }


    static class Producer implements Runnable {
        ShengChanZhe shengChanZhe;

        Producer(ShengChanZhe shengChanZhe) {
            this.shengChanZhe = shengChanZhe;
        }

        @Override
        public void run() {
            while (true) {
                shengChanZhe.produce();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Consumer implements Runnable {
        ShengChanZhe shengChanZhe;

        Consumer(ShengChanZhe shengChanZhe) {
            this.shengChanZhe = shengChanZhe;
        }

        @Override
        public void run() {
            while (true) {
                shengChanZhe.consume();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    {
        System.out.println("block");
    }
    static {
        System.out.println("static block");

    }


    public static void main(String[] args) {
        System.out.println("main");
//        ShengChanZhe shengChanZhe = new ShengChanZhe();
//        shengChanZhe.main(null);//StackOverflowError

//        new Thread(new Producer(shengChanZhe)).start();
//        new Thread(new Producer(shengChanZhe)).start();
//        new Thread(new Producer(shengChanZhe)).start();
//        new Thread(new Producer(shengChanZhe)).start();
//        new Thread(new Producer(shengChanZhe)).start();
//
//        new Thread(new Consumer(shengChanZhe)).start();
//        new Thread(new Consumer(shengChanZhe)).start();
//        new Thread(new Consumer(shengChanZhe)).start();
//        new Thread(new Consumer(shengChanZhe)).start();
//        new Thread(new Consumer(shengChanZhe)).start();

    }


}
