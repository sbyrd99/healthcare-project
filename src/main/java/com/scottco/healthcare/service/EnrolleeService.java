package com.scottco.healthcare.service;

import com.scottco.healthcare.domain.Enrollee;
import com.scottco.healthcare.repo.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EnrolleeService {

    @Autowired
    private EnrolleeRepository repo;

    public List<Enrollee> listAll() {
        return repo.findAll();
    }

    public void save(Enrollee enrollee) {
        repo.save(enrollee);
    }

    public Enrollee get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}