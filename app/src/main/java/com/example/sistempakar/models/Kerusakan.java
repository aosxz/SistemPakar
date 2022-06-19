package com.example.sistempakar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kerusakan {
    private int kodeKerusakan;
    private String namaKerusakan;
    private String deskripsi;
    private String gejalaKerusakan;
    private String solusi;
    private int imageKerusakan;
}
