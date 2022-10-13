package com.practice.pragmapocbackendjava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombres;
    @NonNull
    private String apellidos;
    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY)
    private IdentificacionEntity identificacion;
    @NonNull
    private Integer edad;
    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private CiudadEntity ciudadDeNacimiento;
    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY)
    private FotoEntity foto;

    public static class Atributos {
        public static final String ID = "id";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String IDENTIFICACION = "identificacion";
        public static final String EDAD = "edad";
        public static final String CIUDAD_DE_NACIMIENTO = "ciudadDeNacimiento";
        public static final String FOTO = "foto";
    }
}
