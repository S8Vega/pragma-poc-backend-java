package com.practice.pragmapocbackendjava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ciudad")
public class CiudadEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(unique = true)
    private String nombre;
    @ToString.Exclude
    @OneToMany(mappedBy = "ciudadDeNacimiento", fetch = FetchType.LAZY)
    private List<ClienteEntity> clientes;

    public static class Atributos {
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String CLIENTES = "clientes";
    }
}
