package com.edoc.ConsultationService.vo;

import com.edoc.ConsultationService.model.Consultation;
import com.edoc.ConsultationService.model.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
public class PatientVO implements BaseValueObject {

    private UUID id;

    private String firstName;

    private String lastName;

    private String contact;

    private String gender;

    private Timestamp dateOfBirth;

    private Set<Consultation> consultations = new LinkedHashSet<>();

}
