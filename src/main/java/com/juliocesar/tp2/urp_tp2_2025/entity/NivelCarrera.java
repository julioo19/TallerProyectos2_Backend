package com.juliocesar.tp2.urp_tp2_2025.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "nivel_carrera")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NivelCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nivel_carrera")
    private int idEstadoCarrera;

    @Column(name="nombre_nivel_carrera")
    private String nombreNivelCarrera;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name="updatedAt")
    @UpdateTimestamp
    private LocalDate updatedAt;
}
