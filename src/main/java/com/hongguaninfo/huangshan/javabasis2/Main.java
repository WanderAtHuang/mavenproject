package com.hongguaninfo.huangshan.javabasis2;

public class Main {
    public static void main(String[] args) {

            Store storage = new Store();
            Thread p1 = new Thread(new Producer(storage),"生产者线程");
            //Thread p2 = new Thread(new Producer(storage));
            //Thread p3 = new Thread(new Producer(storage));

            Thread c1 = new Thread(new Consumer(storage),"消费者线程");
            //Thread c2 = new Thread(new Consumer(storage));
            //Thread c3 = new Thread(new Consumer(storage));

            p1.start();
            //p2.start();

            //p3.start();
            c1.start();
            //c2.start();
            //c3.start();




    }
}
