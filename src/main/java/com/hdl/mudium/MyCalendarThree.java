package com.hdl.mudium;

import java.util.TreeMap;

public class MyCalendarThree {
    TreeMap<Integer, Integer> delta;

    public MyCalendarThree() {
        delta = new TreeMap();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        return ans;
    }
    public static void main(String args[]){
         MyCalendarThree obj = new MyCalendarThree();
         int param_1 = obj.book(10,40);
         System.out.println(param_1);
    }
}