package com.iqmsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iqmsoft.concurrency.CyclicBarrierTest;
import com.iqmsoft.datastructures.AllPathApp;
import com.iqmsoft.datastructures.HashTableApp;
import com.iqmsoft.datastructures.HeapApp;
import com.iqmsoft.datastructures.HeapQueueApp;
import com.iqmsoft.datastructures.RefGraphApp;
import com.iqmsoft.datastructures.TreeApp;
import com.iqmsoft.datastructures.TreeHashMapApp;
import com.iqmsoft.datastructures.TreeHeapApp;



@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        
    	
    	
    	SpringApplication.run(Application.class, args);
        
    	TreeApp a = new TreeApp();
    	
    	a.test();
    	
        TreeHeapApp a1 = new TreeHeapApp();
    	
    	a1.test();
    	
    	TreeHashMapApp a3 = new TreeHashMapApp();
    	
    	a3.test();
    	
        HashTableApp a4 = new HashTableApp();
    	
    	a4.test();
    	
    	HeapApp a5 = new HeapApp();
    	
    	a5.test();
    	
    	HeapQueueApp a6 = new HeapQueueApp();
    	
    	a6.test();
    	
    	RefGraphApp a7 = new RefGraphApp();
    	
    	a7.test();
    	
    	AllPathApp a8 = new AllPathApp();
    	
    	a8.test();
    	
    	CyclicBarrierTest cb = new CyclicBarrierTest();
    	
    	cb.test();
    	 
        
    }

}