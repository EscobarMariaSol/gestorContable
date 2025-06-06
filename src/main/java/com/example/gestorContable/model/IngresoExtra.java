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
    private String descripcion;
    private LocalDate fecha;

    //Métodos

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
