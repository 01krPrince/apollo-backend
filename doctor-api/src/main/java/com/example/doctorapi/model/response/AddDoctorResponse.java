package com.example.doctorapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddDoctorResponse {
    private String name;
    private String specialization;
    private int experience;
    private String qualification;
    private String location;
    private String clinicName;
    private int fees;
    private int cashbackAmount;
    private boolean doctorOfTheHour;
    private String availableTime;
    private String profileImageUrl;
}
