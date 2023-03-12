package com.example.MoneyLionAssesment.Service;

import com.example.MoneyLionAssesment.DTO.ResponseDTO;
import com.example.MoneyLionAssesment.Entity.FeatureAccessEntity;
import com.example.MoneyLionAssesment.Repository.FeatureAccessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class FeatureAccessServiceImplementation implements FeatureAccessService {

    @Autowired
    private FeatureAccessRepository featureAccessRepository;

    @Override
    public List<FeatureAccessEntity> getAllFeatureAccess() {
        return featureAccessRepository.findAll();
    }

    @Override
    public FeatureAccessEntity createFeatureAccess(FeatureAccessEntity featureAccess) {
        return featureAccessRepository.save(featureAccess);
    }

    @Override
    public ResponseDTO getFeatureAccessEntityByEmailAndFeatureName(String email, String featureName) {
        List<FeatureAccessEntity> result = featureAccessRepository.findByEmailAndFeatureName(email, featureName);
        if (result.size() > 0) {
            FeatureAccessEntity featureAccessEntity = result.get(0);
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setCanAccess(featureAccessEntity.getEnabled());
            return responseDTO;
        } else {
            return null;
        }
    }
}
