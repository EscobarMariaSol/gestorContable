package com.example.gestorContable.service;

import com.example.gestorContable.dto.IngresoExtraDTO;
import com.example.gestorContable.model.IngresoExtra;
import com.example.gestorContable.repository.IngresoExtraRepository;
import com.example.gestorContable.request.IngresoExtraRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class IngresoExtraService {

    private final IngresoExtraRepository ingresoExtraRepository;
    private final DisponibilidadService disponibilidadService;

    public IngresoExtraService(IngresoExtraRepository ingresoExtraRepository, DisponibilidadService disponibilidadService) {
        this.ingresoExtraRepository = ingresoExtraRepository;
        this.disponibilidadService = disponibilidadService;
    }

    public IngresoExtraDTO registrarIngresoExtra(IngresoExtraRequest request) {
        IngresoExtra extra = new IngresoExtra();
        extra.setMonto(request.getMonto());
        extra.setFecha(LocalDate.now());
        extra.setConcepto(request.getConcepto());

        ingresoExtraRepository.save(extra);
        disponibilidadService.actualizarSaldoConIngresoExtra(request.getMonto());

        return new IngresoExtraDTO(
                extra.getId(),
                extra.getMonto(),
                extra.getFecha(),
                extra.getConcepto()
        );
    }

    public List<IngresoExtra> obtenerTodosLosIngresosExtras() {
        return ingresoExtraRepository.findAll();
    }
}

