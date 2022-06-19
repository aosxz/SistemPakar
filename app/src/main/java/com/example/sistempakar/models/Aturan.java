package com.example.sistempakar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aturan {
    private Gejala gejalaAturan;
    private int aturanKodeKerusakan;
    private int aturanKodeGejala;
    private int level;

    public Aturan(int aturanKodeKerusakan, int aturanKodeGejala, int level) {
        this.aturanKodeKerusakan = aturanKodeKerusakan;
        this.aturanKodeGejala = aturanKodeGejala;
        this.level = level;
    }
}
