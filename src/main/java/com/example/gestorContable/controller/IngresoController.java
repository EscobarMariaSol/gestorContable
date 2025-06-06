package com.example.gestorContable.controller;

import com.example.gestorContable.dto.IngresoDTO;
import com.example.gestorContable.model.Ingreso;
import com.example.gestorContable.request.IngresoRequest;
import com.example.gestorContable.service.IngresoService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingresos")
public class IngresoController {

    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @PostMapping
    public IngresoDTO registrarGasto(@RequestBody IngresoRequest request) {
        return ingresoService.registrarIngreso(request);
    }

    @GetMapping
    public List<IngresoDTO> obtenerIngresos() {
        return ingresoService.obtenerTodosLosIngresos()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private IngresoDTO convertirADTO(Ingreso ingreso) {
        IngresoDTO dto = new IngresoDTO(
                ingreso.getId(),
                ingreso.getMonto(),
                ingreso.getFecha(),
                ingreso.getAhorro().getMonto(),
                ingreso.getGustos().getMonto(),
                ingreso.getNecesidades().getMonto(),
                ingreso.getFondoEmergencia().getMonto()
        );

        return dto;
    }

}

