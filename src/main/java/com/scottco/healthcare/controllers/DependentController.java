package com.scottco.healthcare.controllers;

import com.scottco.healthcare.domain.Dependent;
import com.scottco.healthcare.repo.DependentRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/dependents")
public class DependentController {

    @Autowired
    private DependentRepository repository;

    @GetMapping
    public Iterable<Dependent> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Dependent findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }
    @PostMapping(consumes = "application/json")
    public Dependent create(@RequestBody Dependent dependent) {
        return repository.save(dependent);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Dependent dependent) {
        repository.delete(dependent);
    }

    @PutMapping(path = "/{id}")
    public Dependent update(@PathVariable("id") Integer id, @RequestBody Dependent dependent) throws BadHttpRequest {

        Dependent dependent2 = new Dependent();
        Example<Dependent> example = Example.of(dependent2);
        boolean exists = repository.exists(example);
        if (exists) {
            dependent.setFirstName(dependent.getFirstName());
            dependent.setLastName(dependent.getLastName());
            dependent.setBirthDate(dependent.getBirthDate());
            return repository.save(dependent);
        } else {
            throw new BadHttpRequest();
        }
    }

}
