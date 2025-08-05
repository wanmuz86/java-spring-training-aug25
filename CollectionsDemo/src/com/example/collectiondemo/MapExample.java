package com.example.collectiondemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapExample {

	public static void main(String[] args) {
		// Key and Value <String, Integer>
		// apple -> 1
		// banana -> 2
		// cherry --> 3
		// date -> 5
		
		// name -> "Muzaffar" , location -> "Bandar Utama", profession-> Trainer 
		// <String, String> = in JS this is almost the same as object data type / json
		// TBC next week
		
		Map<String,Integer> hashMap = new HashMap<>(Map.of(
				"apple",1,
				"banana",2,
				"cherry",3,
				"date",5)
				);
		
		Map<String, Integer> treeMap = new TreeMap<>(
				Map.of(
						"apple",1,
						"banana",2,
						"cherry",3,
						"date",5)
				);
		
		System.out.println("Simple hashMap operation");
		System.out.println(hashMap.get("apple"));  // 1
		System.out.println(hashMap.size()); // 4 ()
		System.out.println(hashMap.containsKey("orange")); // false
		
		System.out.println("Retrieveing hash map elements through for loop");
		
		// for each item in the hashmap
		for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
			System.out.println("The key is "+entry.getKey() 
			+" and the value is "+entry.getValue());
		}
		
		
		System.out.println("Retrieving Treemap elements through iterator");
		Iterator treeMapIt = treeMap.entrySet().iterator();
		while(treeMapIt.hasNext()) {
			System.out.println(treeMapIt.next());
		}
		
	}

}
