package com.example.gestorContable.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoDTO {
    private Long id;
    private BigDecimal monto;
    private String categoria;
    private String descripcion;
    private LocalDate fecha;

    public GastoDTO(Long id, BigDecimal monto, String categoria, String descripcion, LocalDate fecha) {
        this.id = id;
        this.monto = monto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

