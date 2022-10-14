package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.ClienteDao;
import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import com.practice.pragmapocbackendjava.entity.FotoEntity;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import com.practice.pragmapocbackendjava.mapper.ClienteMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteRepositoryTest {

    @InjectMocks
    private ClienteRepository clienteRepository;
    @Mock
    private ClienteDao clienteDao;
    @Mock
    private CiudadRepository ciudadRepository;
    @Mock
    private FotoRepository fotoRepository;
    @Mock
    private IdentificacionRepository identificacionRepository;
    @Mock
    private ClienteMapper clienteMapper;

    @Test
    void guardar() {
        final String NOMBRES = "sebas";
        final String APELLIDOS = "vega";
        final String TIPO_IDENTIFICACION = "cedula";
        final String NUMERO_IDENTIFICACION = "12345";
        final int EDAD = 24;
        final String CIUDAD_DE_NACIMIENTO = "cucuta";
        final String FOTO = "base64";
        ClienteDto clienteDto = ClienteDto.builder()
                .nombres(NOMBRES)
                .apellidos(APELLIDOS)
                .tipoIdentificacion(TIPO_IDENTIFICACION)
                .numeroIdentificacion(NUMERO_IDENTIFICACION)
                .edad(EDAD)
                .ciudadDeNacimiento(CIUDAD_DE_NACIMIENTO)
                .foto(FOTO)
                .build();
        when(clienteMapper.toCiudadEntity(clienteDto))
                .thenReturn(new CiudadEntity());
        when(ciudadRepository.guardar(any(CiudadEntity.class)))
                .thenReturn(new CiudadEntity());
        when(clienteMapper.toClienteEntity(clienteDto, new CiudadEntity()))
                .thenReturn(new ClienteEntity());

        clienteRepository.guardar(clienteDto);

        verify(clienteDao).save(any(ClienteEntity.class));
    }

    @Test
    void buscarExiste() {
        final long ID = 1L;
        final String NOMBRES = "sebas";
        final String APELLIDOS = "vega";
        final IdentificacionEntity IDENTIFICACION = new IdentificacionEntity();
        final String TIPO_IDENTIFICACION = "cedula";
        final String NUMERO_IDENTIFICACION = "12345";
        final int EDAD = 24;
        final CiudadEntity CIUDAD = new CiudadEntity();
        final String CIUDAD_DE_NACIMIENTO = "cucuta";
        final FotoEntity FOTO_ENTITY = new FotoEntity();
        final String FOTO = "base64";
        ClienteDto clienteDto = ClienteDto.builder()
                .nombres(NOMBRES)
                .apellidos(APELLIDOS)
                .tipoIdentificacion(TIPO_IDENTIFICACION)
                .numeroIdentificacion(NUMERO_IDENTIFICACION)
                .edad(EDAD)
                .ciudadDeNacimiento(CIUDAD_DE_NACIMIENTO)
                .foto(FOTO)
                .build();
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .id(ID)
                .nombres(NOMBRES)
                .apellidos(APELLIDOS)
                .identificacion(IDENTIFICACION)
                .edad(EDAD)
                .ciudadDeNacimiento(CIUDAD)
                .foto(FOTO_ENTITY)
                .build();
        when(clienteDao.findByIdentificacion(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION))
                .thenReturn(Optional.of(clienteEntity));
        when(clienteMapper.toClienteDto(clienteEntity))
                .thenReturn(clienteDto);

        clienteRepository.buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);

        verify(clienteDao).findByIdentificacion(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);
    }

    @Test
    void buscarNoExiste() {
        final String TIPO_IDENTIFICACION = "cedula";
        final String NUMERO_IDENTIFICACION = "12345";
        when(clienteDao.findByIdentificacion(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION))
                .thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            clienteRepository.buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);
        });

        assertEquals("El documento no existe", exception.getMessage());
        verify(clienteDao).findByIdentificacion(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);
    }

    @Test
    void buscarPorEdadMayorIgualExiste() {
        final int EDAD = 24;
        final List<ClienteEntity> CLIENTES = new ArrayList<>();
        final List<ClienteDto> CLIENTES_DTO = new ArrayList<>();
        when(clienteDao.findByEdadGreaterThanEqual(EDAD))
                .thenReturn(Optional.of(CLIENTES));
        when(clienteMapper.toClienteDto(CLIENTES))
                .thenReturn(CLIENTES_DTO);

        clienteRepository.buscarPorEdadMayorIgual(EDAD);

        verify(clienteDao).findByEdadGreaterThanEqual(EDAD);
        verify(clienteMapper).toClienteDto(CLIENTES);

    }

    @Test
    void buscarPorEdadMayorIgualNoExiste() {
        final int EDAD = 24;
        when(clienteDao.findByEdadGreaterThanEqual(EDAD))
                .thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            clienteRepository.buscarPorEdadMayorIgual(EDAD);
        });

        verify(clienteDao).findByEdadGreaterThanEqual(EDAD);
    }

    @Test
    void actualizar() {
        final long ID = 1L;
        final String NOMBRES = "sebas";
        final String APELLIDOS = "vega";
        final IdentificacionEntity IDENTIFICACION = new IdentificacionEntity();
        final String TIPO_IDENTIFICACION = "cedula";
        final String NUMERO_IDENTIFICACION = "12345";
        final int EDAD = 24;
        final CiudadEntity CIUDAD = new CiudadEntity();
        final String CIUDAD_DE_NACIMIENTO = "cucuta";
        final FotoEntity FOTO_ENTITY = new FotoEntity();
        final String FOTO = "base64";
        ClienteDto clienteDto = ClienteDto.builder()
                .nombres(NOMBRES)
                .apellidos(APELLIDOS)
                .tipoIdentificacion(TIPO_IDENTIFICACION)
                .numeroIdentificacion(NUMERO_IDENTIFICACION)
                .edad(EDAD)
                .ciudadDeNacimiento(CIUDAD_DE_NACIMIENTO)
                .foto(FOTO)
                .build();
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .id(ID)
                .nombres(NOMBRES)
                .apellidos(APELLIDOS)
                .identificacion(IDENTIFICACION)
                .edad(EDAD)
                .ciudadDeNacimiento(CIUDAD)
                .foto(FOTO_ENTITY)
                .build();
        when(clienteDao.findByIdentificacion(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION))
                .thenReturn(Optional.of(clienteEntity));
        when(clienteMapper.toClienteDto(clienteEntity)).thenReturn(clienteDto);

        clienteRepository.actualizar(clienteDto);

        verify(clienteDao).save(clienteEntity);
    }

    @Test
    void eliminar() {
        final long ID = 1L;
        final String NOMBRES = "sebas";
        final String APELLIDOS = "vega";
        final IdentificacionEntity IDENTIFICACION = new IdentificacionEntity();
        final String TIPO_IDENTIFICACION = "cedula";
        final String NUMERO_IDENTIFICACION = "12345";
        final int EDAD = 24;
        final CiudadEntity CIUDAD = new CiudadEntity();
        final String CIUDAD_DE_NACIMIENTO = "cucuta";
        final FotoEntity FOTO_ENTITY = new FotoEntity();
        final String FOTO = "base64";
        ClienteDto clienteDto = ClienteDto.builder()
                .nombres(NOMBRES)
                .apellidos(APELLIDOS)
                .tipoIdentificacion(TIPO_IDENTIFICACION)
                .numeroIdentificacion(NUMERO_IDENTIFICACION)
                .edad(EDAD)
                .ciudadDeNacimiento(CIUDAD_DE_NACIMIENTO)
                .foto(FOTO)
                .build();
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .id(ID)
                .nombres(NOMBRES)
                .apellidos(APELLIDOS)
                .identificacion(IDENTIFICACION)
                .edad(EDAD)
                .ciudadDeNacimiento(CIUDAD)
                .foto(FOTO_ENTITY)
                .build();
        when(clienteDao.findByIdentificacion(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION))
                .thenReturn(Optional.of(clienteEntity));

        clienteRepository.eliminar(clienteDto);

        verify(identificacionRepository).eliminar(any());
        verify(fotoRepository).eliminar(any());
        clienteDao.delete(clienteEntity);
    }
}