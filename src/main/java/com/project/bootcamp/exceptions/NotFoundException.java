package com.project.bootcamp.exceptions;

import com.project.bootcamp.util.MessageUtils;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(){
        // propagando direto
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
