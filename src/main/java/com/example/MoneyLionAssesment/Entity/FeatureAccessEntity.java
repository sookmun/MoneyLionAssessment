package com.example.MoneyLionAssesment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "featureAccess")
public class FeatureAccessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private Boolean enabled;
}
