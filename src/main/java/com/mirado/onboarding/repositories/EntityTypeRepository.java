package com.mirado.onboarding.repositories;

import com.mirado.onboarding.models.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntityTypeRepository extends JpaRepository<EntityType, Integer> {
    Optional<EntityType> findById(Integer id);
}
