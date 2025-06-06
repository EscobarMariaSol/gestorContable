package com.example.gestorContable.service;

import com.example.gestorContable.model.IngresoExtra;
import com.example.gestorContable.repository.IngresoExtraRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class IngresoExtraService {

    private final IngresoExtraRepository ingresoExtraRepository;
    private final DisponibilidadService disponibilidadService;

    public IngresoExtraService(IngresoExtraRepository ingresoExtraRepository, DisponibilidadService disponibilidadService) {
        this.ingresoExtraRepository = ingresoExtraRepository;
        this.disponibilidadService = disponibilidadService;
    }

    public IngresoExtra registrarIngresoExtra(BigDecimal monto, String descripcion) {
        IngresoExtra extra = new IngresoExtra();
        extra.setMonto(monto);
        extra.setDescripcion(descripcion);
        extra.setFecha(LocalDate.now());

        ingresoExtraRepository.save(extra);
        disponibilidadService.actualizarSaldoConIngresoExtra(monto);

        return extra;
    }
}

