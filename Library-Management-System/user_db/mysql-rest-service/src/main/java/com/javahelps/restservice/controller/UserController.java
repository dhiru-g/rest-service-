package com.javahelps.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javahelps.restservice.entity.User;
import com.javahelps.restservice.repository.UserRepository;

import javassist.tools.web.BadHttpRequest;

import java.beans.Statement;
import java.io.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{emailId}")
	public User find(@PathVariable("emailId") String emailID) {
		return repository.findOne(emailID);
	}

	@PostMapping(consumes = "application/json")
	public User create(@RequestBody User user) {
		/*String q = String.format("select username from user ");
		Statement stmt=null;
		String [] usernames=stmt.execute(q);*/

		try {
			//User user = new User();
			String pass=user.getPassword();
			/*FileWriter myWriter = new FileWriter("credentials.txt");
			BufferedWriter bufferedWrite = new BufferedWriter(myWriter);
			PrintWriter write = new PrintWriter(bufferedWrite);*/
			Writer write;
			write = new BufferedWriter(new FileWriter("credentials.txt",true));
			write.append("["+"b7a."+"users."+user.getUsername()+"]\n");
			write.append("password="+'"'+pass+'"'+"\n\n");
			System.out.println("Successfully wrote to the file.");
			write.close();



		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();

		}

		
		return repository.save(user);
	}

	@DeleteMapping(path = "/{emailId}")
	public void delete(@PathVariable("emailId") String emailId) {
		repository.delete(emailId);
	}

	@PutMapping(path = "/{emailId}")
	public User update(@PathVariable("emailId") String emailId, @RequestBody User user) throws BadHttpRequest {
		if (repository.exists(emailId)) {
			user.setEmail(emailId);
			return repository.save(user);
		} else {
			throw new BadHttpRequest();
		}
	}

}