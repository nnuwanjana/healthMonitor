package com.edoc.ConsultationService.controller.v1;

import com.edoc.ConsultationService.service.ConsultationService;
import com.edoc.ConsultationService.vo.ConsultationVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("${spring.data.rest.base-path}/v1/consultation")
public class ConsultationController {

    private final Logger logger = LogManager.getLogger(ConsultationController.class);

    private ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping(value="{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConsultationVO> getConsultation(@PathVariable("id") String id) {
        ConsultationVO response = consultationService.getConsultation(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
