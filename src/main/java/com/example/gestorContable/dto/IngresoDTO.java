package com.example.gestorContable.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IngresoDTO {
    public Long id;
    public BigDecimal monto;
    public LocalDate fecha;
    public BigDecimal necesidades;
    public BigDecimal gustos;
    public BigDecimal fondoDeEmergencia;
    public BigDecimal ahorro;

    public IngresoDTO(
            Long id,
            BigDecimal monto,
            LocalDate fecha,
            BigDecimal necesidades,
            BigDecimal gustos,
            BigDecimal fondo,
            BigDecimal ahorro)
    {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.necesidades = necesidades;
        this.gustos = gustos;
        this.fondoDeEmergencia = fondo;
        this.ahorro = ahorro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setAhorro(BigDecimal ahorro) {
        this.ahorro = ahorro;
    }

    public void setGustos(BigDecimal gustos) {
        this.gustos = gustos;
    }

    public void setNecesidades(BigDecimal necesidades) {
        this.necesidades = necesidades;
    }

    public void setFondoDeEmergencia(BigDecimal fondo) {
        this.fondoDeEmergencia = fondo;
    }
}

