package com.iqmsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    	
        
    }

}