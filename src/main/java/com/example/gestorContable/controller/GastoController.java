package com.example.gestorContable.controller;

import com.example.gestorContable.dto.GastoDTO;
import com.example.gestorContable.model.Gasto;
import com.example.gestorContable.request.GastoRequest;
import com.example.gestorContable.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @PostMapping
    public GastoDTO registrarGasto(@RequestBody GastoRequest request) {
        return gastoService.registrarGasto(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GastoDTO> actualizarGasto(@PathVariable Long id, @RequestBody GastoRequest request) {
        Gasto gastoActualizado = gastoService.actualizarGasto(id, request);
        GastoDTO dto = new GastoDTO(
                gastoActualizado.getId(),
                gastoActualizado.getMonto(),
                gastoActualizado.getCategoria().toString(),
                gastoActualizado.getDescripcion(),
                gastoActualizado.getFecha()
        );
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<Gasto> listarGastos() {

        return gastoService.obtenerTodosLosGastos();
    }

    @GetMapping("/mes")
    public List<GastoDTO> listarPorMes(@RequestParam int mes) {
        return gastoService.listarPorMes(mes);
    }

    @GetMapping("/anio")
    public List<GastoDTO> listarPorAnio(@RequestParam int anio) {
        return gastoService.listarPorAnio(anio);
    }

    @GetMapping("/categoria")
    public List<GastoDTO> listarPorAnio(@RequestParam String categoria) {
        return gastoService.listarPorCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarGasto(@PathVariable Long id) {
        gastoService.eliminarGasto(id);
        return ResponseEntity.ok("Gasto eliminado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoDTO> obtenerGastoPorId(@PathVariable Long id) {
        Gasto gasto = gastoService.obtenerGastoPorId(id);
        GastoDTO dto = new GastoDTO(
                gasto.getId(),
                gasto.getMonto(),
                gasto.getCategoria().toString(),
                gasto.getDescripcion(),
                gasto.getFecha()
        );
        return ResponseEntity.ok(dto);
    }


}
