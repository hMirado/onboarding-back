package com.mirado.onboarding.repositories;

import com.mirado.onboarding.models.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShareholderRepository extends JpaRepository<Shareholder, Integer> {
    Optional<Shareholder> findById(Integer id);
    List<Shareholder> findByCustomerId(Integer id);
}
