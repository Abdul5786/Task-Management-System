package com.Abdul.TaskManagementSystem.exception;

import com.Abdul.TaskManagementSystem.Dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex)
    {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
