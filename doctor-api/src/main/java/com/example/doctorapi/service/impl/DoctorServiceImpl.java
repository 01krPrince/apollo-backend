package com.example.doctorapi.service.impl;

import com.example.doctorapi.model.Doctor;
import com.example.doctorapi.model.response.AddDoctorResponse;
import com.example.doctorapi.model.response.DoctorPageResponse;
import com.example.doctorapi.repository.DoctorRepository;
import com.example.doctorapi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(AddDoctorResponse addDoctorResponse) {
        Doctor doctor = new Doctor();
        doctor.setId(String.valueOf(System.currentTimeMillis()));
        doctor.setName(addDoctorResponse.getName());
        doctor.setSpecialization(addDoctorResponse.getSpecialization());
        doctor.setExperience(addDoctorResponse.getExperience());
        doctor.setQualification(addDoctorResponse.getQualification());
        doctor.setLocation(addDoctorResponse.getLocation());
        doctor.setClinicName(addDoctorResponse.getClinicName());
        doctor.setFees(addDoctorResponse.getFees());
        doctor.setCashbackAmount(addDoctorResponse.getCashbackAmount());
        doctor.setDoctorOfTheHour(addDoctorResponse.isDoctorOfTheHour());
        doctor.setAvailableTime(addDoctorResponse.getAvailableTime());
        doctor.setProfileImageUrl(addDoctorResponse.getProfileImageUrl());

        return doctorRepository.save(doctor);
    }

    public DoctorPageResponse filterDoctors(String specialization, String location, int page, int size, Integer fees) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> doctorPage;

        boolean hasSpecialization = specialization != null && !specialization.isEmpty();
        boolean hasLocation = location != null && !location.isEmpty();
        boolean hasFees = fees != null && fees > 0;

        if (hasSpecialization && hasLocation && hasFees) {
            doctorPage = doctorRepository.findBySpecializationIgnoreCaseAndLocationIgnoreCaseAndFeesLessThanEqual(specialization, location, fees, pageable);
        } else if (hasSpecialization && hasLocation) {
            doctorPage = doctorRepository.findBySpecializationIgnoreCaseAndLocationIgnoreCase(specialization, location, pageable);
        } else if (hasSpecialization && hasFees) {
            doctorPage = doctorRepository.findBySpecializationIgnoreCaseAndFeesLessThanEqual(specialization, fees, pageable);
        } else if (hasLocation && hasFees) {
            doctorPage = doctorRepository.findByLocationIgnoreCaseAndFeesLessThanEqual(location, fees, pageable);
        } else if (hasSpecialization) {
            doctorPage = doctorRepository.findBySpecializationIgnoreCase(specialization, pageable);
        } else if (hasLocation) {
            doctorPage = doctorRepository.findByLocationIgnoreCase(location, pageable);
        } else if (hasFees) {
            doctorPage = doctorRepository.findByFeesLessThanEqual(fees, pageable);
        } else {
            doctorPage = doctorRepository.findAll(pageable);
        }

        return new DoctorPageResponse(
                doctorPage.getContent(),
                doctorPage.getNumber(),
                doctorPage.getTotalPages(),
                doctorPage.getTotalElements(),
                doctorPage.getSize()
        );
    }




}
