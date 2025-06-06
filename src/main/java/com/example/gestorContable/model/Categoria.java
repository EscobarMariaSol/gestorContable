package com.example.gestorContable.model;

import jakarta.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Ej: "Necesidades", "Gustos", etc.

    // Getters y setters
}
