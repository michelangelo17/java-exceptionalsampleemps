package com.lambdaschool.sampleemps.handlers;

import com.lambdaschool.sampleemps.models.ValidationError;

import java.util.List;

public interface HelperFunctions
{
    List<ValidationError> getConstraintViolation(Throwable cause);
}
