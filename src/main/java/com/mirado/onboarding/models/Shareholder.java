package com.mirado.onboarding.models;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@jakarta.persistence.Entity
@Table(name = "shareholders")
public class Shareholder extends AbstractEntity {
    @Column
    private String name;

    @Column(length = 100)
    private String passport;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
