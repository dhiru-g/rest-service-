package com.javahelps.restservice;

import com.javahelps.restservice.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		try{
			File f=new File("credentials.txt");
			if(f.createNewFile()){
				System.out.println("File created: " + f.getName());
			}
			else{
				System.out.print("file already exist");
			}
		} catch (IOException e) {
			System.out.println("an error occured");
			e.printStackTrace();
		}


		/*
		}*/
		SpringApplication.run(Application.class, args);

	}





}
