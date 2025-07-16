package com.focustrack.authservice.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Data
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
@Scope("prototype")
public class ResponseService {
    private int statusCode;
    private String message;
    private String token;
}
