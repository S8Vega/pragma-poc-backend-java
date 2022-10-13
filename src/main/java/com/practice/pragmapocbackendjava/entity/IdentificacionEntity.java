package com.practice.pragmapocbackendjava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "identificacion")
public class IdentificacionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String numero;
    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private ClienteEntity cliente;

    public static class Atributos {
        public static final String ID = "id";
        public static final String TIPO = "tipo";
        public static final String NUMERO = "numero";
        public static final String CLIENTE = "cliente";
    }
}
