package com.edoc.ConsultationService.util.converters;

import com.edoc.ConsultationService.model.BaseModelObject;
import com.edoc.ConsultationService.model.Patient;
import com.edoc.ConsultationService.vo.BaseValueObject;
import com.edoc.ConsultationService.vo.PatientVO;

import java.util.function.Function;

public interface BoToVoConverter<T extends BaseModelObject, R extends BaseValueObject> extends Function<T, R> {

    Function<Patient, PatientVO> PATIENT = (patient) -> {
        PatientVO vo = null;
       if(patient == null){
           return vo;
       }
       vo.setId(patient.getId());
       vo.setFirstName(patient.getFirstName());
       vo.setLastName(patient.getLastName());
       vo.setContact(patient.getContact());
       vo.setDateOfBirth(patient.getDateOfBirth());
       vo.setGender(patient.getGender());
       return vo;
    };
}
