package com.example.evaluacionyalutec.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse {
    private int codigo;
    private String mensaje;

}