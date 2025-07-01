package com.example.gestorContable.service;

import com.example.gestorContable.dto.GastoDTO;
import com.example.gestorContable.model.Categoria;
import com.example.gestorContable.request.GastoRequest;
import com.example.gestorContable.model.Gasto;
import com.example.gestorContable.repository.GastoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GastoService {

    private final GastoRepository gastoRepository;
    private final DisponibilidadService disponibilidadService;

    public GastoService(GastoRepository gastoRepository, DisponibilidadService disponibilidadService) {
        this.gastoRepository = gastoRepository;
        this.disponibilidadService = disponibilidadService;
    }

    @Transactional
    public GastoDTO registrarGasto(GastoRequest request) {
        List<String> categoriasValidas = List.of("GUSTOS", "NECESIDADES", "AHORRO", "FONDOEMERGENCIA");
        String categoriaNormalizada = request.getCategoria().toUpperCase();

        if (!categoriasValidas.contains(categoriaNormalizada)) {
            throw new IllegalArgumentException("Categoría no válida: " + request.getCategoria());
        }

        Gasto gasto = new Gasto();
        gasto.setMonto(request.getMonto());
        gasto.setCategoria(Categoria.valueOf(request.getCategoria().toUpperCase()));
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

    public List<GastoDTO> listarPorMes(int mes) {
        List<Gasto> gastos = gastoRepository.findByMes(mes);
        return crearGastoDTO(gastos);
    }

    public List<GastoDTO> listarPorAnio(int anio) {
        List<Gasto> gastos = gastoRepository.findByAnio(anio);
        return crearGastoDTO(gastos);
    }

    public List<GastoDTO> listarPorCategoria(String categoria) {
        List<Gasto> gastos = gastoRepository.findByCategoria(categoria);
        return crearGastoDTO(gastos);
    }

    public void eliminarGasto(Long id) {
        if (!gastoRepository.existsById(id)) {
            throw new RuntimeException("El gasto con ID " + id + " no existe.");
        }
        gastoRepository.deleteById(id);
    }

    private List<GastoDTO> crearGastoDTO(List<Gasto> gastos) {
        return gastos.stream().map(g -> new GastoDTO(
                g.getId(),
                g.getMonto(),
                g.getCategoria(),
                g.getDescripcion(),
                g.getFecha())).collect(Collectors.toList());
    }

    public Gasto obtenerGastoPorId(Long id) {
        return gastoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado con ID: " + id));
    }

    public Gasto actualizarGasto(Long id, GastoRequest request) {
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado con ID: " + id));

        gasto.setMonto(request.getMonto());
        gasto.setCategoria(Categoria.valueOf(request.getCategoria().toUpperCase()));
        gasto.setDescripcion(request.getDescripcion());

        return gastoRepository.save(gasto);
    }
}

