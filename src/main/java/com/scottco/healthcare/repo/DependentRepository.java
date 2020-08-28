package com.scottco.healthcare.repo;

import com.scottco.healthcare.domain.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface DependentRepository extends JpaRepository<Dependent, Integer> {
}
