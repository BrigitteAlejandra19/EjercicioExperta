package com.example.ejercicioexperta.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BarErrorResponse {

   private int status;
   private String message;

    public BarErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static BarErrorResponse build(int status, String message) {
        return new BarErrorResponse(status, message);
    }

}
