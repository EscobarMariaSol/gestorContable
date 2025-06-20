package com.example.gestorContable.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class IngresoExtra {

    //Atributos

    @Id @GeneratedValue
    private Long id;

    private BigDecimal monto;
    private LocalDate fecha;
    private String concepto;

    //Métodos

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Long getId() {
        return this.id;
    }

    public BigDecimal getMonto() {
        return this.monto;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public String getConcepto() {
        return this.concepto;
    }
}
