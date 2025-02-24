package com.mirado.onboarding.repositories;

import com.mirado.onboarding.models.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAll(Specification specification);
    Optional<Customer> findCustomerByCompany(String company);
}
