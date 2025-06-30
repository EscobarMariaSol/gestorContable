package com.example.gestorContable.controller;

import com.example.gestorContable.dto.IngresoDTO;
import com.example.gestorContable.model.Ingreso;
import com.example.gestorContable.request.IngresoRequest;
import com.example.gestorContable.service.IngresoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @PostMapping
    public IngresoDTO registrarGasto(@RequestBody IngresoRequest request) {
        return ingresoService.registrarIngreso(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarIngreso(@PathVariable Long id) {
        ingresoService.eliminarIngreso(id);
        return ResponseEntity.ok("Ingreso eliminado correctamente");
    }

    @GetMapping
    public List<IngresoDTO> obtenerIngresos() {
        return ingresoService.obtenerTodosLosIngresos()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngresoDTO> obtenerIngresoPorId(@PathVariable Long id) {
        Ingreso ingreso = ingresoService.obtenerIngresoPorId(id);
        IngresoDTO dto = convertirADTO(ingreso);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngresoDTO> modificarIngreso(@PathVariable Long id, @RequestBody IngresoRequest request) {
        Ingreso ingresoActualizado = ingresoService.modificarIngreso(id, request);
        IngresoDTO dto = convertirADTO(ingresoActualizado);
        return ResponseEntity.ok(dto);
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

