package com.hongguaninfo.huangshan.javabasis2;

public class Consumer implements Runnable{

    private Store store;

    public Consumer(){}

    public Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(3000);
                store.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
