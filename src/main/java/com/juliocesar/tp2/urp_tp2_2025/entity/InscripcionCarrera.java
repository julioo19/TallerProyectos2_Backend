package com.juliocesar.tp2.urp_tp2_2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inscripcion_carrera")
public class InscripcionCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcionCarrera;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @Column(name="fecha_inscripcion")
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_estado_carrera")
    private EstadoCarrera estadoCarrera;

    @Column(name="fecha_estado_carrera")
    private LocalDate fechaEstadoCarrera;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name="updatedAt")
    @UpdateTimestamp
    private LocalDate updatedAt;
}
