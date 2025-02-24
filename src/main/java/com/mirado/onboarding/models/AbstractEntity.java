package com.mirado.onboarding.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Instant createdDate;

    @SoftDelete
    @Column(name = "deleted_at")
    private Instant deleted;

    @PrePersist
    protected void onCreate() {
        createdDate = Instant.now();
    }
}

