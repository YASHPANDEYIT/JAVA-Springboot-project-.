package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class service {
@Autowired
public Repository repo;



public String addEntity(Entity entity) {
	
	repo.save(entity);
	String message = "added the entity";
	
	return message;
	
}

public Optional<Entity> retrieveEntity(int id) {
	
	Optional<Entity> e = repo.findById(id);
	
	
	return e;
	
}
public String removeEntity(int id)
{
	String message ="removed successfully";
	repo.deleteById(id);
	return message;

}


		
}
