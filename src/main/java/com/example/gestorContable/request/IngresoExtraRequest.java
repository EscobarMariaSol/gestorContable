package com.example.gestorContable.request;

import java.math.BigDecimal;

public class IngresoExtraRequest {
    private BigDecimal monto;
    private String concepto;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}

