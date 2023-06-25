package com.oldandsea.pcb.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorObject {
    private String messsage;
    private HttpStatus status;
}
