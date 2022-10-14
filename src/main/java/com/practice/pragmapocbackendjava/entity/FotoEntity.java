package com.practice.pragmapocbackendjava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@Table(name = "foto")
public class FotoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String base64;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    public static class Atributos {
        public static final String ID = "id";
        public static final String BASE64 = "base64";
        public static final String CLIENTE = "cliente";
    }
}
