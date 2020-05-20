package com.hongguaninfo.huangshan.javabasis2;

import java.util.LinkedList;

public class Store  {
    final int MAX_SIZE = 20;
    LinkedList<Object> list = new LinkedList();
    public void produce() {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("【生产者" + Thread.currentThread().getName() + "】仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }

    public void consume() {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println(  Thread.currentThread().getName() + "仓库为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println(Thread.currentThread().getName()
                    + "】消费一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }
}

