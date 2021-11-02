package org.example.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadDemo4 {
    public static void main(String[] args) {
        // arrayList演示
//        ArrayList<String> list = new ArrayList<>();
        //通过vector来解决arrayList线程不安全问题
//        Vector<String> list = new Vector<>();
        //通过Collections工具类来解决list线程不安全问题
//        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        //通过CopyOnWriteArrayList来解决arrayList线程不安全问题
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
             list.add(UUID.randomUUID().toString().substring(0,8));
             System.out.println(list);
            },String.valueOf(i)).start();
        }

       //set演示
//        HashSet<String> set = new HashSet<>();
        //通过CopyOnWriteArraySet来解决set线程安全问题
       /* CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }*/

       //hashMap演示
//        HashMap<String, String> map = new HashMap<>();
        //通过ConcurrentHashMap来解决hashMap线程安全问题
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            String key=String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
