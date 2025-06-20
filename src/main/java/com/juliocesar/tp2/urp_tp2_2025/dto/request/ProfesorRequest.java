package com.juliocesar.tp2.urp_tp2_2025.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorRequest {
    String nombre;
    String apellido;
    String email;
    String numeroTelefono;

}
