package com.example.doctorapi.model.response;

import com.example.doctorapi.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPageResponse {
    private List<Doctor> doctors;
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private int pageSize;
}
