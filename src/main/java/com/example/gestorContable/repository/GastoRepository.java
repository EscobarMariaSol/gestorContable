package com.example.gestorContable.repository;

import com.example.gestorContable.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

    @Query("SELECT g FROM Gasto g WHERE MONTH(g.fecha) = :mes")
    List<Gasto> findByMes(@Param("mes") int mes);

    @Query("SELECT g FROM Gasto g WHERE YEAR(g.fecha) = :anio")
    List<Gasto> findByAnio(@Param("anio") int anio);

    @Query("SELECT g FROM Gasto g WHERE LOWER(g.categoria) = LOWER(:categoria)")
    List<Gasto> findByCategoria(@Param("categoria") String categoria);

}
