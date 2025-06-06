package com.example.gestorContable.request;

import java.math.BigDecimal;

public class GastoRequest {
    private BigDecimal monto;
    private String categoria;
    private String descripcion;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
