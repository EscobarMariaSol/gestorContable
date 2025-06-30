package com.example.gestorContable.controller;

import com.example.gestorContable.model.Disponibilidad;
import com.example.gestorContable.service.DisponibilidadService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disponibilidad")
public class DisponibilidadController {

    private final DisponibilidadService service;

    public DisponibilidadController(DisponibilidadService service) {
        this.service = service;
    }

    // GET /disponibilidad
    @GetMapping
    public Disponibilidad getDisponibilidad() {
        return service.obtenerDisponibilidad();
    }

}
