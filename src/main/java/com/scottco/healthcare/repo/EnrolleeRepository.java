package com.scottco.healthcare.repo;

import com.scottco.healthcare.domain.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface EnrolleeRepository extends JpaRepository<Enrollee, Integer> {
}
