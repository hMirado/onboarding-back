package com.mirado.onboarding.repositories;

import com.mirado.onboarding.models.Business;
import com.mirado.onboarding.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
