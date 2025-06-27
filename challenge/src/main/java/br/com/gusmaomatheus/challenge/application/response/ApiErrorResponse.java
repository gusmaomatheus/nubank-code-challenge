package br.com.gusmaomatheus.challenge.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Collections;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ApiErrorResponse {
    private final String requestUri;
    private final String requestMethod;
    private final int statusCode;
    private final String statusMessage;
    private final String errorMessage;
    private List<String> errors;

    public ApiErrorResponse(HttpServletRequest request, HttpStatus status, String errorMessage) {
        this.requestUri = request.getRequestURI();
        this.requestMethod = request.getMethod();
        this.statusCode = status.value();
        this.statusMessage = status.getReasonPhrase();
        this.errorMessage = errorMessage;
    }

    public ApiErrorResponse(HttpServletRequest request, HttpStatus status, String errorMessage, BindingResult validationResult) {
        this.requestUri = request.getRequestURI();
        this.requestMethod = request.getMethod();
        this.statusCode = status.value();
        this.statusMessage = status.getReasonPhrase();
        this.errorMessage = errorMessage;
        setErrors(validationResult);
    }

    private void setErrors(BindingResult validationResult) {
        List<FieldError> fieldErrors = validationResult.getFieldErrors();

        if (fieldErrors.isEmpty()) {
            this.errors = Collections.emptyList();
        }

        for (FieldError fieldError : fieldErrors) {
            final String message = String.format("Parâmetro inválido: %s", fieldError.getDefaultMessage());

            this.errors.add(message);
        }

    }
}