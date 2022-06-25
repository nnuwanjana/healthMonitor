package com.edoc.ConsultationService.util.converters;

import com.edoc.ConsultationService.exception.DataConversionException;


import java.util.UUID;

public class UUIDConverter {


    public static UUID toUUID(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new DataConversionException("Invalid format in uuid : " + uuid);
        }
    }

}
