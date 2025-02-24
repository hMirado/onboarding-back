package com.mirado.onboarding.repositories;

import com.mirado.onboarding.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
    Optional<Business> findById(Integer id);
}
