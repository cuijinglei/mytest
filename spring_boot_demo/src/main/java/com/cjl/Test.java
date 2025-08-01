package com.cjl;

import com.cjl.singleton.EHan;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.misc.Contended;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    @Contended
    private int a;
    private String b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.stream()
        .filter(item->1==1);
        try {
            String sql = "SELECT * FROM users WHERE id = 1";
            SqlParser parser = SqlParser.create(sql);
            SqlNode sqlNode = parser.parseQuery();
            System.out.println(sqlNode.toString());
        } catch (SqlParseException e) {
            e.printStackTrace();
        }
        Thread.State aNew = Thread.State.NEW;
        FutureTask<Integer> f = new FutureTask<>(() ->null);

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        threadLocal.remove();

        HashMap hashMap = new HashMap();
        hashMap.put("", "");

        for (int i = 1; i < 10; i++)
            if (1 == 1)
                System.out.println("");

        EHan.getInstance();
        ReentrantLock a = new ReentrantLock();
        a.lock();
        Condition condition = a.newCondition();
        new HashMap<>();
        new LinkedBlockingQueue<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10
                , TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(() -> {
        });
        threadPoolExecutor.submit(() -> {
        });
        new Thread(() -> {
        });
        FutureTask<Integer> t = new FutureTask<>(() -> 1);
        new Thread(t);
    }

    public <T> Collection<T> abc() {
        new JdbcTemplate();
        BeanPostProcessor.class.isAssignableFrom(FutureTask.class);
        return new ArrayList<>();
    }
}
