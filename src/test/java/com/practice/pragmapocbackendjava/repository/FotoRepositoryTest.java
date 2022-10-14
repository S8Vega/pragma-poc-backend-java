package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.FotoDao;
import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import com.practice.pragmapocbackendjava.entity.FotoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FotoRepositoryTest {

    @InjectMocks
    private FotoRepository repository;
    @Mock
    private FotoDao dao;

    @Test
    void guardar() {
        final long ID = 1L;
        final String BASE64 = "foto en base64";
        final ClienteEntity CLIENTE = new ClienteEntity();
        FotoEntity entity = FotoEntity.builder()
                .id(ID)
                .base64(BASE64)
                .cliente(CLIENTE)
                .build();

        repository.guardar(entity);

        verify(dao).save(entity);
    }

    @Test
    void eliminar() {
        final long ID = 1L;
        final String BASE64 = "foto en base64";
        final ClienteEntity CLIENTE = new ClienteEntity();
        FotoEntity entity = FotoEntity.builder()
                .id(ID)
                .base64(BASE64)
                .cliente(CLIENTE)
                .build();

        repository.eliminar(entity);

        verify(dao).delete(entity);
    }
}