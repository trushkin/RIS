package com.example.springrest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    public People findById(int id) {
        Optional<People> person = peopleRepository.findById(id);
        return person.orElseThrow(PeopleNotFoundException::new);
    }

    public void addPerson(People people) {
        peopleRepository.save(people);
    }

    public void deletePerson(int id) {
        Optional<People> person = peopleRepository.findById(id);
        person.ifPresent(p -> peopleRepository.delete(p));
    }

    public People updatePerson(People people) {
        Optional<People> person = peopleRepository.findById(people.getId());
        if (person.isPresent()) {
            return peopleRepository.save(person.get());
        }
        return person.orElseThrow(PeopleNotFoundException::new);
    }
}
