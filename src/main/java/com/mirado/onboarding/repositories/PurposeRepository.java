package com.mirado.onboarding.repositories;

import com.mirado.onboarding.models.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurposeRepository extends JpaRepository<Purpose, Integer> {
    Optional<Purpose> findById(Integer id);
}
