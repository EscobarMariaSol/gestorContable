package com.example.gestorContable.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
public class Disponibilidad {

    @Id
    private Long id = 1L;

    private BigDecimal ahorro = BigDecimal.ZERO;
    private BigDecimal gustos = BigDecimal.ZERO;
    private BigDecimal necesidades = BigDecimal.ZERO;
    private BigDecimal fondoEmergencia = BigDecimal.ZERO;
    private BigDecimal totalGeneral = BigDecimal.ZERO;

    private LocalDate ultimaActualizacion;

    // Métodos

    public void setId(long id) {
        this.id = id;
    }

    public void setUltimaActualizacion(LocalDate now) {
        this.ultimaActualizacion = now;
    }

    public void setTotalGeneral(BigDecimal total){
        this.totalGeneral = total;
    }
    public void setAhorro(BigDecimal ahorro){
        this.ahorro = ahorro;
    }

    public void setGustos(BigDecimal gustos){
        this.gustos = gustos;
    }

    public void setNecesidades(BigDecimal necesidades){
        this.necesidades = necesidades;
    }

    public void setFondoEmergencia(BigDecimal fondo){
        this.fondoEmergencia = fondo;
    }

    public BigDecimal getTotalGeneral() {
        return this.totalGeneral;
    }

    public BigDecimal getAhorro() {
        return this.ahorro;
    }

    public BigDecimal getGustos() {
        return this.gustos;
    }

    public BigDecimal getNecesidades() {
        return this.necesidades;
    }

    public BigDecimal getFondoEmergencia() {
        return this.fondoEmergencia;
    }


}

