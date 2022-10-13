package com.practice.pragmapocbackendjava.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ClienteDto {

    private String nombres;
    private String apellidos;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Integer edad;
    private String ciudadDeNacimiento;
    private String foto;

    public static class Atributos {
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String TIPO_IDENTIFICACION = "tipoIdentificacion";
        public static final String NUMERO_IDENTIFICACION = "numeroIdentificacion";
        public static final String EDAD = "edad";
        public static final String CIUDAD_DE_NACIMIENTO = "ciudadDeNacimiento";
        public static final String FOTO = "foto";
    }
}
