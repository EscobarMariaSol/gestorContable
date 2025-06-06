package com.example.gestorContable.service;

import com.example.gestorContable.dto.IngresoDTO;
import com.example.gestorContable.model.*;
import com.example.gestorContable.repository.IngresoRepository;
import com.example.gestorContable.request.IngresoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class IngresoService {

    private final IngresoRepository ingresoRepository;

    private final DisponibilidadService disponibilidadService;

    public IngresoService(IngresoRepository ingresoRepository, DisponibilidadService disponibilidadService) {
        this.ingresoRepository = ingresoRepository;
        this.disponibilidadService = disponibilidadService;
    }

    public IngresoDTO registrarIngreso(IngresoRequest request) {
        Ingreso ingreso = new Ingreso();
        ingreso.setMonto(request.getMonto());
        ingreso.setFecha(LocalDate.now());

        // Distribución automática
        Ahorro ahorro = new Ahorro();
        ahorro.setMonto(request.getMonto().multiply(new BigDecimal("0.30")));
        ahorro.setIngreso(ingreso);
        ingreso.setAhorro(ahorro);

        Gustos gustos = new Gustos();
        gustos.setMonto(request.getMonto().multiply(new BigDecimal("0.25")));
        gustos.setIngreso(ingreso);
        ingreso.setGustos(gustos);

        Necesidades necesidades = new Necesidades();
        necesidades.setMonto(request.getMonto().multiply(new BigDecimal("0.25")));
        necesidades.setIngreso(ingreso);
        ingreso.setNecesidades(necesidades);

        FondoDeEmergencia fondo = new FondoDeEmergencia();
        fondo.setMonto(request.getMonto().multiply(new BigDecimal("0.20")));
        fondo.setIngreso(ingreso);
        ingreso.setFondoEmergencia(fondo);

        // Guardar ingreso
        Ingreso guardado = ingresoRepository.save(ingreso);

        // Actualizar saldo disponible
        disponibilidadService.actualizarSaldoConIngreso(guardado);

        return new IngresoDTO(
                guardado.getId(),
                guardado.getMonto(),
                guardado.getFecha(),
                guardado.getNecesidades().getMonto(),
                guardado.getGustos().getMonto(),
                guardado.getFondoEmergencia().getMonto(),
                guardado.getAhorro().getMonto()
        );
    }

    public Ingreso obtenerIngresoPorId(Long id) {
        return ingresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingreso no encontrado"));
    }


    public List<Ingreso> obtenerTodosLosIngresos() {

        return ingresoRepository.findAll();
    }


}
