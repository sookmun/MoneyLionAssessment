package com.example.MoneyLionAssesment.DTO;

import lombok.Data;

@Data
public class FeatureAccessDTO {
    private long id;
    private String featureName;
    private String email;
    private Boolean enabled;
}
