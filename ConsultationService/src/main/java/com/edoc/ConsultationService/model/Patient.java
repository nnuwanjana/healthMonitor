package com.edoc.ConsultationService.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cs_patient")
@Getter
@Setter
public class Patient implements BaseModelObject {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String firstName;

    private String lastName;

    private String contact;

    private String gender;

    private Timestamp dateOfBirth;

    @OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Consultation> consultations = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(gender, patient.gender) && Objects.equals(dateOfBirth, patient.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, dateOfBirth);
    }
}
