package com.tcc.yago.ranqueamentoapi.domain.topico;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topico")
@CrossOrigin(origins = {"https://ranqueamento-front-production.up.railway.app", "http://localhost:4200"}, maxAge = 3600, allowCredentials="true")
public class TopicoController {
//
//    private final TopicoService topicoService;
//
//    @GetMapping("/listar")
//    List<Topico> listar() {
//        return topicoService.listar();
//    }
}
