package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.CiudadDao;
import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CiudadRepositoryTest {

    @InjectMocks
    private CiudadRepository repository;
    @Mock
    private CiudadDao dao;

    @Test
    void guardarExiste() {
        final long ID = 1L;
        final String NOMBRE = "cucuta";
        final List<ClienteEntity> CLIENTES = new ArrayList<>();
        CiudadEntity entity = CiudadEntity.builder()
                .id(ID)
                .nombre(NOMBRE)
                .clientes(CLIENTES)
                .build();
        when(dao.findByNombre(NOMBRE)).thenReturn(Optional.of(entity));

        repository.guardar(entity);

        verify(dao).findByNombre(NOMBRE);
    }

    @Test
    void guardarNoExiste() {
        final long ID = 1L;
        final String NOMBRE = "cucuta";
        final List<ClienteEntity> CLIENTES = new ArrayList<>();
        CiudadEntity entity = CiudadEntity.builder()
                .id(ID)
                .nombre(NOMBRE)
                .clientes(CLIENTES)
                .build();
        when(dao.save(entity)).thenReturn(entity);
        when(dao.findByNombre(NOMBRE)).thenReturn(Optional.empty());

        repository.guardar(entity);

        verify(dao).save(entity);
        verify(dao).findByNombre(NOMBRE);
    }

    @Test
    void buscarPorNombre() {
        final long ID = 1L;
        final String NOMBRE = "cucuta";
        final List<ClienteEntity> CLIENTES = new ArrayList<>();
        CiudadEntity entity = CiudadEntity.builder()
                .id(ID)
                .nombre(NOMBRE)
                .clientes(CLIENTES)
                .build();
        when(dao.findByNombre(NOMBRE)).thenReturn(Optional.of(entity));

        repository.buscarPorNombre(NOMBRE);

        verify(dao).findByNombre(NOMBRE);
    }
}