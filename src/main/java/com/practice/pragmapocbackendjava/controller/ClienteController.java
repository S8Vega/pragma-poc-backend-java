package com.practice.pragmapocbackendjava.controller;

import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.service.ClienteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> guardar(@RequestBody ClienteDto clienteDto) throws Exception {
        log.info("guardar");
        return ResponseEntity.ok(clienteService.guardar(clienteDto));
    }

    @GetMapping("/identificacion/{tipo}/{numero}")
    public ResponseEntity<ClienteDto> buscar(@PathVariable String tipo,
                                             @PathVariable String numero) throws Exception {
        log.info("buscar");
        ClienteDto clienteDto = clienteService.buscar(tipo, numero);
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<List<ClienteDto>> buscarPorEdadMayorIgual(@PathVariable int edad) throws Exception {
        log.info("buscarPorEdadMayorIgual");
        return ResponseEntity.ok(clienteService.buscarPorEdadMayorIgual(edad));
    }

    @PutMapping
    public ResponseEntity<ClienteDto> actualizar(@RequestBody ClienteDto clienteDto) throws Exception {
        log.info("actualizar");
        return ResponseEntity.ok(clienteService.actualizar(clienteDto));
    }

    @DeleteMapping
    public ResponseEntity<ClienteDto> eliminar(@RequestBody ClienteDto clienteDto) throws Exception {
        log.info("eliminar");
        clienteService.eliminar(clienteDto);
        return ResponseEntity.ok(clienteDto);
    }
}
