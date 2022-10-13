package com.practice.pragmapocbackendjava.controller;

import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.service.ClienteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> guardar(@RequestBody ClienteDto clienteDto) throws Exception {
        log.info("guardar");
        clienteService.guardar(clienteDto);
        return ResponseEntity.ok(clienteDto);
    }
}