package com.example.gestorContable.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IngresoExtraDTO {
    public Long id;
    public BigDecimal monto;
    public LocalDate fecha;
    public String concepto;

    public IngresoExtraDTO(
            Long id,
            BigDecimal monto,
            LocalDate fecha,
            String concepto) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.concepto = concepto;
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

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}


