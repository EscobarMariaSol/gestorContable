package com.example.gestorContable.controller;

import com.example.gestorContable.dto.GastoDTO;
import com.example.gestorContable.model.Gasto;
import com.example.gestorContable.request.GastoRequest;
import com.example.gestorContable.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @PostMapping
    public GastoDTO registrarGasto(@RequestBody GastoRequest request) {
        return gastoService.registrarGasto(request);
    }

    @GetMapping
    public List<Gasto> listarGastos() {

        return gastoService.obtenerTodosLosGastos();
    }

}
