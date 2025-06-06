package com.example.gestorContable.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Ingreso {

    @Id @GeneratedValue
    private Long id;

    private BigDecimal monto;
    private LocalDate fecha;

    @OneToOne(mappedBy = "ingreso", cascade = CascadeType.ALL)
    private Ahorro ahorro;

    @OneToOne(mappedBy = "ingreso", cascade = CascadeType.ALL)
    private Gustos gustos;

    @OneToOne(mappedBy = "ingreso", cascade = CascadeType.ALL)
    private Necesidades necesidades;

    @OneToOne(mappedBy = "ingreso", cascade = CascadeType.ALL)
    private FondoDeEmergencia fondoDeEmergencia;


    public Long getId() {
        return id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
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

    public void setAhorro(Ahorro ahorro) {
        this.ahorro = ahorro;
    }

    public void setGustos(Gustos gustos) {
        this.gustos = gustos;
    }

    public void setNecesidades(Necesidades necesidades) {
        this.necesidades = necesidades;
    }

    public void setFondoEmergencia(FondoDeEmergencia fondo) {
        this.fondoDeEmergencia = fondo;
    }

    public Ahorro getAhorro() {
        return this.ahorro;
    }

    public Gustos getGustos() {
        return this.gustos;
    }

    public Necesidades getNecesidades() {
        return this.necesidades;
    }

    public FondoDeEmergencia getFondoEmergencia() {
        return this.fondoDeEmergencia;
    }
}
