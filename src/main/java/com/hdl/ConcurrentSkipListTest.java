package com.hdl;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
 
 
public class ConcurrentSkipListTest {
	public static final int ADD_NUM = 3;
	public static final int THREAD_NUM = 2;
	public static List<Thread> threads = new ArrayList<Thread>();
	
	public static void doIt(final Map<String, String> map) {
		threads.clear();
		for (int i = 0; i < THREAD_NUM; i++) {
			threads.add(new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < ADD_NUM; i++) {
						String str = UUID.randomUUID().toString();
						map.put(str, str);
					}
				}
				
			}));
			threads.get(i).start();
		}
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String args[]) {
		Map<String, String> hmap = new ConcurrentHashMap<>();
		addContent(hmap);
		Map<String, String> smap = new ConcurrentSkipListMap<>();
		addContent(smap);

		printMap(hmap);
		printMap(smap);
	}

	private static void addContent(Map<String, String> map) {
		long startTime = System.currentTimeMillis();
		ConcurrentSkipListTest.doIt(map);
		long endTime = System.currentTimeMillis();
		System.out.println(map.getClass().getSimpleName()+" put cost time:"+(endTime - startTime)+"MS");
	}

	private static void printMap(Map<String, String> map) {
		System.out.println("-----------");
		System.out.println(map.getClass().getSimpleName());
		for(Iterator its = map.keySet().iterator(); its.hasNext();){
			System.out.println(its.next());
		}
	}
}
