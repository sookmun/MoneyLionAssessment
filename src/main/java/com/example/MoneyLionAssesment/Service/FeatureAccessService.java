package com.example.MoneyLionAssesment.Service;

import com.example.MoneyLionAssesment.DTO.ResponseDTO;
import com.example.MoneyLionAssesment.Entity.FeatureAccessEntity;

import java.util.List;

public interface FeatureAccessService {
    List<FeatureAccessEntity> getAllFeatureAccess();

    FeatureAccessEntity createFeatureAccess(FeatureAccessEntity featureAccess);

    ResponseDTO getFeatureAccessEntityByEmailAndFeatureName(String email, String featureName);
}
