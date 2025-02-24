package com.mirado.onboarding.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "entity")
public class EntityType extends AbstractEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "entityType")
    private List<Customer> customers;
}
