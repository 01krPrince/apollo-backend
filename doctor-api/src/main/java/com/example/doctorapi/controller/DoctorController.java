
package com.example.doctorapi.controller;

import com.example.doctorapi.model.Doctor;
import com.example.doctorapi.model.response.AddDoctorResponse;
import com.example.doctorapi.model.response.DoctorPageResponse;
import com.example.doctorapi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody AddDoctorResponse addDoctorResponse) {
        return doctorService.addDoctor(addDoctorResponse);
    }

    @GetMapping("/filterDoctors")
    public DoctorPageResponse listDoctors(
            @RequestParam(defaultValue = "") String specialization,
            @RequestParam(defaultValue = "") String location,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "1000") int fee
    ) {
        return doctorService.filterDoctors(specialization, location, page, size, fee);
    }

}
