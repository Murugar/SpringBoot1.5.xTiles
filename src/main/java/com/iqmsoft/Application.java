package com.iqmsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iqmsoft.datastructures.TreeApp;



@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        
    	
    	
    	SpringApplication.run(Application.class, args);
        
    	TreeApp a = new TreeApp();
    	
    	a.test();
    	
        
    }

}