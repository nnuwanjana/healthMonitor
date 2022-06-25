package com.edoc.ConsultationService.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cs_consultation")
@Getter
@Setter
public class Consultation implements BaseModelObject {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String diagnosis;

    private String bloodPressure;

    private Timestamp createdDate;

    private Timestamp modifiedDate;

    private boolean isLatest;

    @ManyToOne
    @JoinColumn(name = "doctor_Id")
    private User doctorId;

    @ManyToOne
    @JoinColumn(name = "patient_Id")
    private Patient patientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return isLatest == that.isLatest && Objects.equals(diagnosis, that.diagnosis) && Objects.equals(bloodPressure, that.bloodPressure) && Objects.equals(createdDate, that.createdDate) && Objects.equals(doctorId, that.doctorId) && Objects.equals(patientId, that.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagnosis, bloodPressure, createdDate, isLatest, doctorId, patientId);
    }
}
