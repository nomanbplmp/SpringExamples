package com.example.demo.greetings.resource;

import com.example.demo.greetings.publisher.GreetingPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/")
public class GreetingsResource {
    private static TreeMap<Integer, String> greetRepo = new TreeMap<>();

    @Autowired
    private GreetingPublisher greetingPublisher;

    static {
        greetRepo.put(1, "hello");
        greetRepo.put(2, "welcome");
        greetRepo.put(3, "salam");
    }


    @GetMapping(path = "greetings")
    @ResponseBody
    public ResponseEntity<Collection<String>> list() {
        return new ResponseEntity<Collection<String>>(greetRepo.values(), HttpStatus.OK);
    }

    @GetMapping(path = "greetings/{id}")
    public ResponseEntity<String> get(@PathVariable Integer id) {
        return new ResponseEntity<String>(greetRepo.get(id), HttpStatus.OK);
    }

    @PutMapping(path = "greetings/{id}")
    public ResponseEntity<String> update(@PathVariable(value = "id") Integer id, @RequestBody String greet) {
        greetRepo.put(id,greet);
        return new ResponseEntity<String>(greetRepo.get(id), HttpStatus.OK);
    }


    @PostMapping("/greetings")
    public ResponseEntity<Object> add(@RequestBody String greet) {
        Integer id = addGreetToRepo(greet);
        greetingPublisher.broadcast(greet);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "greetings/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@PathVariable Integer id) {
       synchronized(greetRepo){
           greetRepo.remove(id);
       }

        return new ResponseEntity<String>(greetRepo.get(id), HttpStatus.OK);
    }




    private synchronized Integer addGreetToRepo(String greet) {
        Integer key = greetRepo.size();
        greetRepo.put(++key, greet);
        return key;
    }

}
