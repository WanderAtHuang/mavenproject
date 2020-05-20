package com.hongguaninfo.huangshan.javabasis2;

public class Producer implements Runnable {

    private Store store;

    public Producer(){}

    public Producer(Store store){
        this.store = store;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1500);
                store.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
