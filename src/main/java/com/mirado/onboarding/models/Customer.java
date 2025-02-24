package com.mirado.onboarding.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity {
    @Column(unique = true, nullable = false)
    private String company;

    @Column(unique = true, nullable = true)
    private String license;

    @Column(unique = true, nullable = false)
    private String country;

    @Column(name = "registrat_number",unique = true, nullable = false)
    private String registrationNumber;

    @Column(name = "incorporation_date", nullable = false)
    private Date incorporationDate;

    @Column(unique = true, nullable = false)
    private String applicant;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "purpose_id")
    private Purpose purpose;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private EntityType entityType;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(mappedBy = "customer")
    private List<Shareholder> shareholders;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
