package com.edoc.ConsultationService.service;

import com.edoc.ConsultationService.configuration.security.UserContextHolder;
import com.edoc.ConsultationService.exception.ObjectNotFoundException;
import com.edoc.ConsultationService.exception.RequiredDataNotFoundException;
import com.edoc.ConsultationService.model.Patient;
import com.edoc.ConsultationService.repository.PatientRepository;
import com.edoc.ConsultationService.util.converters.BoToVoConverter;
import com.edoc.ConsultationService.util.converters.UUIDConverter;
import com.edoc.ConsultationService.vo.PatientVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final Logger logger = LogManager.getLogger(PatientService.class);
    private final PatientRepository patientRepository;

    PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public PatientVO getPatient(String id) {
        if (id.isBlank()) {
            throw new RequiredDataNotFoundException("Id can not be empty");
        }
        Patient patient = patientRepository.findById(UUIDConverter.toUUID(id)).orElseThrow(() -> {
            logger.error("No Patient with id :{}", id);
            return new ObjectNotFoundException("No Patient with id :" + id);
        });
        return BoToVoConverter.PATIENT.apply(patient);
    }
}
