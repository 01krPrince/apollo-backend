package com.example.doctorapi.service;

import com.example.doctorapi.model.Doctor;
import com.example.doctorapi.model.response.AddDoctorResponse;
import com.example.doctorapi.model.response.DoctorPageResponse;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(AddDoctorResponse addDoctorResponse);
    DoctorPageResponse filterDoctors(String specialization, String location, int page, int size, Integer fee);

}