package com.mirado.onboarding.models;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@jakarta.persistence.Entity
@Table(name = "business")
public class Business extends AbstractEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "business")
    private List<Customer> customers;
}
