package com.Abdul.TaskManagementSystem.exception;

public class ResourceNotFoundException extends RuntimeException
{
    String resourceName;
    String fieldName;
    Integer fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue)
    {
        super(String.format("%s resource with resource   %s:%s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Integer fieldValue) {
        this.fieldValue = fieldValue;
    }
}
