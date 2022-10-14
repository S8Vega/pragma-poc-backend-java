package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.IdentificacionDao;
import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IdentificacionRepositoryTest {

    @InjectMocks
    private IdentificacionRepository repository;
    @Mock
    private IdentificacionDao dao;

    @Test
    void guardarExiste() {
        final long ID = 1L;
        final String TIPO = "cedula";
        final String NUMERO = "123456";
        final ClienteEntity CLIENTE = new ClienteEntity();
        IdentificacionEntity entity = IdentificacionEntity.builder()
                .id(ID)
                .tipo(TIPO)
                .numero(NUMERO)
                .cliente(CLIENTE)
                .build();
        when(dao.findByTipoAndNumero(TIPO, NUMERO)).thenReturn(Optional.of(entity));

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            repository.guardar(entity);
        });

        assertEquals("La identificacion ya existe", exception.getMessage());
        verify(dao).findByTipoAndNumero(TIPO, NUMERO);
    }

    @Test
    void guardarNoExiste() {
        final long ID = 1L;
        final String TIPO = "cedula";
        final String NUMERO = "123456";
        final ClienteEntity CLIENTE = new ClienteEntity();
        IdentificacionEntity entity = IdentificacionEntity.builder()
                .id(ID)
                .tipo(TIPO)
                .numero(NUMERO)
                .cliente(CLIENTE)
                .build();
        when(dao.findByTipoAndNumero(TIPO, NUMERO)).thenReturn(Optional.empty());

        repository.guardar(entity);

        verify(dao).save(entity);
        verify(dao).findByTipoAndNumero(TIPO, NUMERO);
    }

    @Test
    void buscarPorTipoYNumero() {
        final long ID = 1L;
        final String TIPO = "cedula";
        final String NUMERO = "123456";
        final ClienteEntity CLIENTE = new ClienteEntity();
        IdentificacionEntity entity = IdentificacionEntity.builder()
                .id(ID)
                .tipo(TIPO)
                .numero(NUMERO)
                .cliente(CLIENTE)
                .build();
        when(dao.findByTipoAndNumero(TIPO, NUMERO)).thenReturn(Optional.of(entity));

        repository.buscarPorTipoYNumero(TIPO, NUMERO);

        verify(dao).findByTipoAndNumero(TIPO, NUMERO);
    }

    @Test
    void eliminar() {
        final long ID = 1L;
        final String TIPO = "cedula";
        final String NUMERO = "123456";
        final ClienteEntity CLIENTE = new ClienteEntity();
        IdentificacionEntity entity = IdentificacionEntity.builder()
                .id(ID)
                .tipo(TIPO)
                .numero(NUMERO)
                .cliente(CLIENTE)
                .build();

        repository.eliminar(entity);

        verify(dao).delete(entity);
    }
}