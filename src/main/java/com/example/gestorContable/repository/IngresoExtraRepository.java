package com.example.gestorContable.repository;

import com.example.gestorContable.model.IngresoExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoExtraRepository extends JpaRepository<IngresoExtra, Long> {
}
