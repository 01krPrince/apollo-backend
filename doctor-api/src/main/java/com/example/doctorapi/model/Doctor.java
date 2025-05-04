package com.example.doctorapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    private String id;

    private String name;                     // e.g., Dr. Shruti Goswami
    private String specialization;           // e.g., General Physician/ Internal Medicine
    private int experience;                  // e.g., 13 (years)
    private String qualification;            // e.g., M.D. PHYSICIAN
    private String location;                 // e.g., Pune or Chennai
    private String clinicName;               // e.g., Apollo Clinic, Kharadi, Pune
    private int fees;                        // e.g., ₹500
    private int cashbackAmount;              // e.g., ₹75 or ₹50 cashback
    private boolean doctorOfTheHour;         // e.g., for special highlighting
    private String availableTime;            // e.g., "Available tomorrow at 12:30 AM"
    private String profileImageUrl;          // URL of the doctor's avatar/profile
}
