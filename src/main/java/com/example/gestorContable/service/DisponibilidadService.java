package com.example.gestorContable.service;

import com.example.gestorContable.model.Disponibilidad;
import com.example.gestorContable.model.Gasto;
import com.example.gestorContable.model.Ingreso;
import com.example.gestorContable.repository.DisponibilidadRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DisponibilidadService {

    private final DisponibilidadRepository disponibilidadRepository;

    public DisponibilidadService(DisponibilidadRepository disponibilidadRepository) {
        this.disponibilidadRepository = disponibilidadRepository;
    }

    public Disponibilidad obtenerDisponibilidad() {
        return disponibilidadRepository.findById(1L).orElseGet(() -> {
            Disponibilidad nueva = new Disponibilidad();
            nueva.setId(1L);
            nueva.setUltimaActualizacion(LocalDate.now());
            return disponibilidadRepository.save(nueva);
        });
    }

    public Disponibilidad actualizarDisponibilidad(Disponibilidad actualizada) {
        actualizada.setId(1L);
        actualizada.setUltimaActualizacion(LocalDate.now());
        return disponibilidadRepository.save(actualizada);
    }

    public void actualizarSaldoConIngresoExtra(BigDecimal monto) {
        Disponibilidad saldo = obtenerDisponibilidad();
        saldo.setTotalGeneral(saldo.getTotalGeneral().add(monto));
        saldo.setUltimaActualizacion(LocalDate.now());
        disponibilidadRepository.save(saldo);
    }

    public void actualizarSaldoConIngreso(Ingreso ingreso) {
        Disponibilidad saldo = obtenerDisponibilidad();

        saldo.setAhorro(saldo.getAhorro().add(ingreso.getAhorro().getMonto()));
        saldo.setGustos(saldo.getGustos().add(ingreso.getGustos().getMonto()));
        saldo.setNecesidades(saldo.getNecesidades().add(ingreso.getNecesidades().getMonto()));
        saldo.setFondoEmergencia(saldo.getFondoEmergencia().add(ingreso.getFondoEmergencia().getMonto()));

        BigDecimal totalNuevo = ingreso.getAhorro().getMonto()
                .add(ingreso.getGustos().getMonto())
                .add(ingreso.getNecesidades().getMonto())
                .add(ingreso.getFondoEmergencia().getMonto());

        saldo.setTotalGeneral(saldo.getTotalGeneral().add(totalNuevo));
        saldo.setUltimaActualizacion(LocalDate.now());

        disponibilidadRepository.save(saldo);
    }

    public void actualizarSaldoConGasto(Gasto gasto) {
        Disponibilidad disponibilidad = obtenerDisponibilidad(); // tu lógica actual

        BigDecimal monto = gasto.getMonto();
        String categoria = gasto.getCategoria();

        switch (categoria.toUpperCase()) {
            case "GUSTOS" -> disponibilidad.setGustos(disponibilidad.getGustos().subtract(monto));
            case "NECESIDADES" -> disponibilidad.setNecesidades(disponibilidad.getNecesidades().subtract(monto));
            case "AHORRO" -> disponibilidad.setAhorro(disponibilidad.getAhorro().subtract(monto));
            case "FONDOEMERGENCIA" -> disponibilidad.setFondoEmergencia(disponibilidad.getFondoEmergencia().subtract(monto));
            default -> throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }

        disponibilidadRepository.save(disponibilidad);
    }

}
