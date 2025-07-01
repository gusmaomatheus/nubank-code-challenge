package br.com.gusmaomatheus.challenge.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ApiResponse<T> {

    private final String timestamp;
    private final String requestUri;
    private final String requestMethod;
    private final int statusCode;
    private final String statusMessage;

    private final T data;
    private final String errorMessage;
    private final List<String> errors;

    private ApiResponse(String requestUri, String requestMethod, int statusCode, String statusMessage,
                        T data, String errorMessage, List<String> errors) {
        this.timestamp = LocalDateTime.now().toString();
        this.requestUri = requestUri;
        this.requestMethod = requestMethod;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
        this.errorMessage = errorMessage;
        this.errors = errors;
    }

    public static <T> ApiResponse<T> success(HttpServletRequest request, HttpStatus status, T data) {
        return new ApiResponse<>(
                request.getRequestURI(),
                request.getMethod(),
                status.value(),
                status.getReasonPhrase(),
                data,
                null,
                null
        );
    }

    public static <T> ApiResponse<T> error(HttpServletRequest request, HttpStatus status, String errorMessage) {
        return new ApiResponse<>(
                request.getRequestURI(),
                request.getMethod(),
                status.value(),
                status.getReasonPhrase(),
                null,
                errorMessage,
                null
        );
    }

    public static <T> ApiResponse<T> error(HttpServletRequest request, HttpStatus status, String errorMessage, BindingResult validationResult) {
        List<String> fieldMessages = new ArrayList<>();

        for (FieldError fieldError : validationResult.getFieldErrors()) {
            fieldMessages.add(String.format("Parâmetro inválido: %s", fieldError.getDefaultMessage()));
        }

        return new ApiResponse<>(
                request.getRequestURI(),
                request.getMethod(),
                status.value(),
                status.getReasonPhrase(),
                null,
                errorMessage,
                fieldMessages.isEmpty() ? Collections.emptyList() : fieldMessages
        );
    }
}