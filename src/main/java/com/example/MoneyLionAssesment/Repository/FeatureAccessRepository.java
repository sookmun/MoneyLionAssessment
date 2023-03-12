package com.example.MoneyLionAssesment.Repository;

import com.example.MoneyLionAssesment.Entity.FeatureAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureAccessRepository extends JpaRepository<FeatureAccessEntity, Long> {

    List<FeatureAccessEntity> findByEmailAndFeatureName(String featureName, String email);
}
