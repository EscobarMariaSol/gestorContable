package com.example.gestorContable.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Necesidades {

    //Atributos

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal monto;

    @OneToOne
    @JoinColumn(name = "ingreso_id")
    @JsonIgnore
    private Ingreso ingreso;

    // Métodos

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public BigDecimal getMonto() {
        return this.monto;
    }
}
