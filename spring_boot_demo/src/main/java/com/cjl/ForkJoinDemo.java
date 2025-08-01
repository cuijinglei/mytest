package com.cjl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Integer> {
    final int n;

    ForkJoinDemo(int n) {
        this.n = n;
    }

    /**
     * 重写RecursiveTask的compute()方法
     * @return
     */
    protected Integer compute() {
        if (n <= 1)
            return n;
        ForkJoinDemo f1 = new ForkJoinDemo(n - 1);
        //提交任务
        f1.fork();
        ForkJoinDemo f2 = new ForkJoinDemo(n - 2);
        //合并结果
        return f2.compute() + f1.join();
    }
    public static void main(String[] args) {
        //构建forkjoin线程池
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(10);
        //提交任务并一直阻塞直到任务 执行完成返回合并结果。
        int result = pool.invoke(task);
        System.out.println(result);

        //CompletableFuture.runAsync();

    }
}
