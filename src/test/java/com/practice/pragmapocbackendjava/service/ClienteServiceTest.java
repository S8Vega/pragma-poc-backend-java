package com.practice.pragmapocbackendjava.service;

import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;
    @Mock
    private ClienteRepository repository;

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
        when(repository.guardar(clienteDto)).thenReturn(clienteDto);

        service.guardar(clienteDto);

        verify(repository).guardar(clienteDto);
    }

    @Test
    void buscar() {
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
        when(repository.buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION))
                .thenReturn(clienteDto);

        service.buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);

        verify(repository).buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);
    }

    @Test
    void buscarPorEdadMayorIgual() {
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
        when(repository.buscarPorEdadMayorIgual(EDAD)).thenReturn(Collections.singletonList(clienteDto));

        service.buscarPorEdadMayorIgual(EDAD);

        verify(repository).buscarPorEdadMayorIgual(EDAD);
    }

    @Test
    void actualizar() {
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
        when(repository.actualizar(clienteDto)).thenReturn(clienteDto);

        service.actualizar(clienteDto);

        verify(repository).actualizar(clienteDto);
    }

    @Test
    void eliminar() {
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

        service.eliminar(clienteDto);

        verify(repository).eliminar(clienteDto);
    }
}