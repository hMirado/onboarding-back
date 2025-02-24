package com.mirado.onboarding.specifications;

import com.mirado.onboarding.models.Customer;
import com.mirado.onboarding.models.Shareholder;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CustomerSpec extends AbstractionSpec<Customer> {

    @Override
    protected Predicate toPredicate(Root<Customer> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Join<Customer, Shareholder> join = root.join("shareholders");
        Predicate shareholderNotDeleted = criteriaBuilder.isNull(join.get("deleted"));
        predicates.add((shareholderNotDeleted));
        predicates.add(isNotDeleted(root, criteriaBuilder));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
