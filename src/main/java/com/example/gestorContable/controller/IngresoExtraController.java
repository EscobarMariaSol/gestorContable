package com.example.gestorContable.controller;

import com.example.gestorContable.dto.IngresoDTO;
import com.example.gestorContable.dto.IngresoExtraDTO;
import com.example.gestorContable.model.IngresoExtra;
import com.example.gestorContable.request.IngresoExtraRequest;
import com.example.gestorContable.service.IngresoExtraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ingresos_extras")
public class IngresoExtraController {

    private final IngresoExtraService ingresoExtraService;

    public IngresoExtraController(IngresoExtraService ingresoExtraService) {
        this.ingresoExtraService = ingresoExtraService;
    }

    @PostMapping
    public IngresoExtraDTO registrarIngresoExtra(@RequestBody IngresoExtraRequest request) {
        return ingresoExtraService.registrarIngresoExtra(request);
    }

    @GetMapping
    public List<IngresoExtraDTO> obtenerIngresosExtras() {
        return ingresoExtraService.obtenerTodosLosIngresosExtras()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarIngresoExtra(@PathVariable Long id) {
        ingresoExtraService.eliminarIngresoExtra(id);
        return ResponseEntity.ok("Ingreso eliminado correctamente");
    }

    private IngresoExtraDTO convertirADTO(IngresoExtra ingreso) {
        IngresoExtraDTO dto = new IngresoExtraDTO(
                ingreso.getId(),
                ingreso.getMonto(),
                ingreso.getFecha(),
                ingreso.getConcepto()
        );

        return dto;
    }

}

