package com.example.demo;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class Controler {

    // 1. Make both fields private and final
    private final service s;
    private final WebClient webclient;

    // 2. Add this single constructor. Spring will automatically inject both beans here!
    public Controler(service s, WebClient webclient) {
        this.s = s;
        this.webclient = webclient;
    }
	
    @PostMapping("/post")
    ResponseEntity<String> createEntity(@RequestBody Entity entity) {
        String message = s.addEntity(entity);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Entity> showEntity(@PathVariable int id) {
        Optional<Entity> e = s.retrieveEntity(id);
        if (e.isPresent()) {
            return ResponseEntity.ok(e.get()); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> DeleteEntity(@PathVariable int id) {
        String m = s.removeEntity(id);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }
	
    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        String response = webclient.get()
                .uri("http://localhost:8081/api/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/greetings")
    public ResponseEntity<String> greetings() {
    	String response = "Hi welcome to springboot";
        
        return ResponseEntity.ok(response);
    }
    @GetMapping("/Hello")
    public ResponseEntity<String> Hello()
    {
    	String Res = "Hello its Me";
    	return new ResponseEntity<>(Res,HttpStatus.OK);
    }
    
    @GetMapping("/getBalance/{id}")
    public ResponseEntity<Integer> getBalance(@PathVariable int id)
    {
    	int bal = s.getBal(id);
		return new ResponseEntity<>(bal,HttpStatus.OK);
    	
    }
   
}