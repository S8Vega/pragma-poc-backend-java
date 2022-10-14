package com.practice.pragmapocbackendjava.controller;

import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {
    @InjectMocks
    private ClienteController controller;
    @Mock
    private ClienteService service;

    @Test
    void guardar() throws Exception {
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
        when(service.guardar(clienteDto)).thenReturn(clienteDto);

        ResponseEntity<ClienteDto> response = controller.guardar(clienteDto);

        verify(service).guardar(clienteDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteDto, response.getBody());
    }

    @Test
    void buscar() throws Exception {
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
        when(service.buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION)).thenReturn(clienteDto);

        ResponseEntity<ClienteDto> response = controller.buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);

        verify(service).buscar(TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteDto, response.getBody());
    }

    @Test
    void buscarPorEdadMayorIgual() throws Exception {
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
        when(service.buscarPorEdadMayorIgual(EDAD)).thenReturn(Collections.singletonList(clienteDto));

        ResponseEntity<List<ClienteDto>> response = controller.buscarPorEdadMayorIgual(EDAD);

        verify(service).buscarPorEdadMayorIgual(EDAD);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Collections.singletonList(clienteDto), response.getBody());
    }

    @Test
    void actualizar() throws Exception {
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
        when(service.actualizar(clienteDto)).thenReturn(clienteDto);

        ResponseEntity<ClienteDto> response = controller.actualizar(clienteDto);

        verify(service).actualizar(clienteDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteDto, response.getBody());
    }

    @Test
    void eliminar() throws Exception {
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

        ResponseEntity<ClienteDto> response = controller.eliminar(clienteDto);

        verify(service).eliminar(clienteDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteDto, response.getBody());
    }
}