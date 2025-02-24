package com.mirado.onboarding.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public abstract class AbstractionSpec<T> implements Specification<T> {

    protected Predicate isNotDeleted(Root<T> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.isNull((root.get("deleted")));
    }

    protected abstract Predicate toPredicate(Root<T> root, CriteriaBuilder criteriaBuilder);
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = toPredicate(root, criteriaBuilder);
        Predicate isNotDeleted = isNotDeleted(root, criteriaBuilder);
        predicate =criteriaBuilder.and(predicate, isNotDeleted);
        return predicate;
    }
}
