package com.example.gestorContable.request;

import java.math.BigDecimal;

public class IngresoRequest {
    private BigDecimal monto;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
