package com.cjl.queue;

import java.util.concurrent.DelayQueue;

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.take();
    }
}
