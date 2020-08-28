package com.scottco.healthcare.controllers;

import com.scottco.healthcare.domain.Enrollee;
import com.scottco.healthcare.repo.EnrolleeRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/enrollees")
public class EnrolleeController {

    @Autowired
    private EnrolleeRepository repository;

    @GetMapping
    public Iterable<Enrollee> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Enrollee findById(@PathVariable("id") Integer id) {
        System.out.println("Inside FindById");
        return repository.findById(id).orElse(null);
    }
    @PostMapping(consumes = "application/json")
    public Enrollee create(@RequestBody Enrollee enrollee) {
        return repository.save(enrollee);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Enrollee enrollee) {
        repository.delete(enrollee);
    }

    @PutMapping(path = "/{id}")
    public Enrollee update(@PathVariable("id") Integer id, @RequestBody Enrollee enrollee) throws BadHttpRequest {

        Enrollee enrollee1 = new Enrollee();
        Example<Enrollee> example = Example.of(enrollee1);
        boolean exists = repository.exists(example);
        if (exists) {
            enrollee.setFirstName(enrollee.getFirstName());
            enrollee.setLastName(enrollee.getLastName());
            enrollee.setActivated(enrollee.isActivated());
            enrollee.setBirthDate(enrollee.getBirthDate());
            if (enrollee.getPhoneNumber() != null)
            enrollee.setPhoneNumber(enrollee.getPhoneNumber());
            return repository.save(enrollee);
        } else {
            throw new BadHttpRequest();
        }
    }

}
