package com.example.springrest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @GetMapping("/{id}")
    public ResponseEntity<People> getPerson(@PathVariable("id") int id){
        return ResponseEntity.ok(peopleService.findById(id));
    }
    @GetMapping()
    public ResponseEntity<List<People>> getAllPeople(){
        return ResponseEntity.ok(peopleService.findAll());
    }
    @PostMapping
    public void addPerson(@RequestBody People people){
        peopleService.addPerson(people);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") int id){
        peopleService.deletePerson(id);
    }
    @PutMapping
    public ResponseEntity<People> update(@RequestBody People people){
        return ResponseEntity.ok(peopleService.updatePerson(people));
    }

    @ExceptionHandler
    private ResponseEntity<PeopleErrorResponse> handleException(PeopleNotFoundException e){
        PeopleErrorResponse response = new PeopleErrorResponse(
                "Person with this id wasn't found",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
