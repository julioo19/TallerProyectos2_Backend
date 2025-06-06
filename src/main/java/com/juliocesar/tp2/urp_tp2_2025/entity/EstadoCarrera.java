package com.juliocesar.tp2.urp_tp2_2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="estado_carrera")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstadoCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estado_carrera")
    private int idEstadoCarrera;
    @Column(name="nombre_estado_carrera")
    private String nombreEstadoCarrera;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name="updatedAt")
    @UpdateTimestamp
    private LocalDate updatedAt;
}
