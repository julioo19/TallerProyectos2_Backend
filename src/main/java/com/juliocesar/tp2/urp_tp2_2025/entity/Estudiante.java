package com.juliocesar.tp2.urp_tp2_2025.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@Table(name = "estudiante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @Column(name="id_estudiante")
    private String codigoEstudiante;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name="email")
    private String email;

    @Column(name="numero_telefono")
    private String numeroTelefono;

    @Column(name="created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
