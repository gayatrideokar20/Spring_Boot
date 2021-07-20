package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(final Integer id) {
        return personRepository.findById(id).get();
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person updatePerson(Integer id, String name) {
        Person person = personRepository.findById(id).get();
        person.setName(name);
        personRepository.save(person);
        return personRepository.findById(id).get();
    }

    public List<Person> deletePerson(final Integer id) {
        personRepository.deleteById(id);
        return personRepository.findAll();
    }

}