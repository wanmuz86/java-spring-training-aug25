package com.example.collectiondemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		
		// Create a List of String => ArrayList
		// import the required packages as you are typing 
		// with ctrl + space or select it from the error
		List<String> arrayList = new ArrayList<>();
		List<String> linkedList = new LinkedList<>();
		
		// add methods to add item in the List
		arrayList.add("apple");
		arrayList.add("banana");
		arrayList.add("cherry");
		arrayList.add("date");
		arrayList.add("elderberry");
		
		
		linkedList.add("apple");
		linkedList.add("banana");
		linkedList.add("cherry");
		linkedList.add("date");
		linkedList.add("elderberry");
		
		System.out.println("ArrayList: "+arrayList);
		System.out.println("LinkedList: "+linkedList);
		
		
		
		// Access and Modify elements
		String thirdElementArrayList = arrayList.get(2);
		String thirdElementLinkedList = linkedList.get(2);
		
		System.out.println("Third element for ArrayList is "+thirdElementArrayList);
		System.out.println("Third element for LinkedList is "+thirdElementLinkedList);
		
		
		arrayList.set(2, "citrus");
		linkedList.set(2, "citrues");
		
		System.out.println("Modified ArrayList "+arrayList);
		System.out.println("Modified LinkedList "+linkedList);
		
		
		// Iterating arrayList and LinkedList
		
		// for loop (as yesterday's example)
		
		System.out.println("Iterating ArrayList elements");
		for(String fruit: arrayList) {
			System.out.println(fruit);
		}
		
		// Collection Iterator Interface
		System.out.println("Iterating LinkedList element");
		Iterator<String> iterator = linkedList.iterator();
		// AS long as there is item in the list
		while(iterator.hasNext()) {
			// show the item
			System.out.println(iterator.next());
		}
		
		// Performance comparison
	
		
		List<Integer> arrayListNumber = new ArrayList<>();
		List<Integer> linkedListNumber = new LinkedList<>();
		
		// Get the currenttime in nanoseconds
		long startTime = System.nanoTime();
		for (int i = 0 ; i< 10000; i++ ) {
			arrayListNumber.add(i);
		}
		
		long endTime = System.nanoTime();
		long duration = endTime- startTime;
		System.out.println("Time taken to add 10000 items in arrayList is "+duration+ " ns");
		
		
		long startTimeLinked = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedListNumber.add(i);
		}
		
		long endTimeLinked = System.nanoTime();
		long durationLinked = endTimeLinked-startTimeLinked;
		System.out.println("Time taken to add 10000 item in linkedlist is "+durationLinked 
				+" ns");
	}

}
