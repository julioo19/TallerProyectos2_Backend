package com.juliocesar.tp2.urp_tp2_2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="carrera")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_carrera")
    private int idCarrera;

    @Column(name="nombre_carrera")
    private String nombreCarrera;
    @Column(name="duracion_anhos")
    private int duracionAnhos;
    @Column(name="cursos_electivos_requeridos")
    private int cursosElectivosRequeridos;

    @ManyToOne
    @JoinColumn(name = "id_nivel_carrera")
    private NivelCarrera nivelCarrera;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name="updatedAt")
    @UpdateTimestamp
    private LocalDate updatedAt;

}
