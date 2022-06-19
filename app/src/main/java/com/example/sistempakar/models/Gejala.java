package com.example.sistempakar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gejala {
    private int kodeGejala;
    private String namaGejala;
    private int imageKerusakan;
}
