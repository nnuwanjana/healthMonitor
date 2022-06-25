package com.edoc.ConsultationService.controller.v1;

import com.edoc.ConsultationService.service.PatientService;
import com.edoc.ConsultationService.util.converters.BoToVoConverter;
import com.edoc.ConsultationService.vo.PatientVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("${spring.data.rest.base-path}/v1/patient")
public class PatientController {

    private final Logger logger = LogManager.getLogger(PatientController.class);
    private final PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value="{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PatientVO> getPatient(@PathVariable("id") String id) {
        PatientVO response =patientService.getPatient(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
