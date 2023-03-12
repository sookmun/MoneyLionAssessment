package com.example.MoneyLionAssesment.Controller;

import com.example.MoneyLionAssesment.DTO.FeatureAccessDTO;
import com.example.MoneyLionAssesment.DTO.ResponseDTO;
import com.example.MoneyLionAssesment.Entity.FeatureAccessEntity;
import com.example.MoneyLionAssesment.Service.FeatureAccessService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class FeatureAccessController {
    @Autowired
    private ModelMapper modelMapper;

    private FeatureAccessService featureAccessService;

    public FeatureAccessController(FeatureAccessService featureAccessService) {
        super();
        this.featureAccessService = featureAccessService;
    }

    @GetMapping(path = "/allFeature")
    public List<FeatureAccessDTO> getAllFeatureAccess() {
        return featureAccessService.getAllFeatureAccess().stream().map(post -> modelMapper.map(post, FeatureAccessDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/feature")
    public ResponseEntity getFeatureAccessByEmailAndFeatureName(@RequestParam String email, @RequestParam String featureName) {
        ResponseDTO response = featureAccessService.getFeatureAccessEntityByEmailAndFeatureName(email, featureName);
        if (response == null) {
            return new ResponseEntity("Feature not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(path = "/feature")
    public ResponseEntity createFeatureAccess(@RequestBody FeatureAccessDTO featureAccessDTO) {

        // map DTO to entity
        FeatureAccessEntity featureAccessRequest = modelMapper.map(featureAccessDTO, FeatureAccessEntity.class);

        try {
            FeatureAccessEntity featureAccessEntity = featureAccessService.createFeatureAccess(featureAccessRequest);
            modelMapper.map(featureAccessEntity, FeatureAccessDTO.class);
            // map entity back to DTO
            return new ResponseEntity(HttpStatus.OK);

        } catch (Exception exception) {
            log.error(exception.getMessage());
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }


    }


}
