package com.example.doctorapi.repository;

import com.example.doctorapi.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    // When specialization, location and fee are present
    Page<Doctor> findBySpecializationIgnoreCaseAndLocationIgnoreCaseAndFeesLessThanEqual(String specialization, String location, int fee, Pageable pageable);

    // When specialization and fee are present
    Page<Doctor> findBySpecializationIgnoreCaseAndFeesLessThanEqual(String specialization, int fees, Pageable pageable);

    // When location and fee are present
    Page<Doctor> findByLocationIgnoreCaseAndFeesLessThanEqual(String location, int fees, Pageable pageable);

    // When only fee is present
    Page<Doctor> findByFeesLessThanEqual(int fees, Pageable pageable);

    // When specialization and location are present
    Page<Doctor> findBySpecializationIgnoreCaseAndLocationIgnoreCase(String specialization, String location, Pageable pageable);

    // When only specialization is present
    Page<Doctor> findBySpecializationIgnoreCase(String specialization, Pageable pageable);

    // When only location is present
    Page<Doctor> findByLocationIgnoreCase(String location, Pageable pageable);
}
