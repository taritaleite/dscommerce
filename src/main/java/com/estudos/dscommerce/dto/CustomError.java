package com.estudos.dscommerce.dto;

import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private String error;
    private Integer status;
    private String path;

    public CustomError(Instant timestamp,  Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public String getError() {
        return error;
    }


    public Instant getTimestamp() {
        return timestamp;
    }


    public Integer getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

}

