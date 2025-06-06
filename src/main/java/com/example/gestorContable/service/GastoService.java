package com.example.gestorContable.service;

import com.example.gestorContable.dto.GastoDTO;
import com.example.gestorContable.request.GastoRequest;
import com.example.gestorContable.model.Gasto;
import com.example.gestorContable.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GastoService {

    private final GastoRepository gastoRepository;
    private final DisponibilidadService disponibilidadService;

    public GastoService(GastoRepository gastoRepository, DisponibilidadService disponibilidadService) {
        this.gastoRepository = gastoRepository;
        this.disponibilidadService = disponibilidadService;
    }

    public GastoDTO registrarGasto(GastoRequest request) {
        Gasto gasto = new Gasto();
        gasto.setMonto(request.getMonto());
        gasto.setCategoria(request.getCategoria().toUpperCase());
        gasto.setDescripcion(request.getDescripcion().toUpperCase());
        gasto.setFecha(LocalDate.now());

        Gasto guardado = gastoRepository.save(gasto);

        disponibilidadService.actualizarSaldoConGasto(guardado);

        return new GastoDTO(
                guardado.getId(),
                guardado.getMonto(),
                guardado.getCategoria(),
                guardado.getDescripcion(),
                guardado.getFecha()
        );
    }

    public List<Gasto> obtenerTodosLosGastos() {

        return gastoRepository.findAll();
    }
}

