package com.juliocesar.tp2.urp_tp2_2025.repository;

import com.juliocesar.tp2.urp_tp2_2025.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, String>{

    @Query(nativeQuery = true, value = "SELECT e.id_estudiante FROM estudiante e WHERE e.id_estudiante LIKE :patron ORDER BY e.id_estudiante DESC LIMIT 1")
    Optional<String> findLastIDPatronLike(@Param("patron") String patron);
}
