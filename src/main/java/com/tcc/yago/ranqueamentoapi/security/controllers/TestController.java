package com.tcc.yago.ranqueamentoapi.security.controllers;

import com.tcc.yago.ranqueamentoapi.domain.comentario.Comentario;
import com.tcc.yago.ranqueamentoapi.domain.comentario.ComentarioService;
import com.tcc.yago.ranqueamentoapi.domain.comentario.dto.ComentarioParaSalvarDTO;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.TecnologiasService;
import com.tcc.yago.ranqueamentoapi.domain.topico.Topico;
import com.tcc.yago.ranqueamentoapi.domain.topico.TopicoService;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicoDTO;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicoSalvarDTO;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicosListagemDTO;
import com.tcc.yago.ranqueamentoapi.domain.votos.Votos;
import com.tcc.yago.ranqueamentoapi.domain.votos.VotosService;
import com.tcc.yago.ranqueamentoapi.domain.votos.dto.VotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = {"https://ranqueamento-front-production.up.railway.app", "http://localhost:4200"}, maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api")
public class TestController {

  
  @Autowired
  TopicoService topicoService;

  @Autowired
  TecnologiasService tecnologiasService;

  @Autowired
  VotosService votosService;

  @Autowired
  ComentarioService comentarioService;

  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }


  // Topico

  @PostMapping("/topico/salvar")
  public Topico salvar(@RequestBody TopicoSalvarDTO topico) {
    return topicoService.salvar(topico);
  }

  @GetMapping("/topico/listarTopicosPorVotacao")
  public List<TopicosListagemDTO> listarTopicosPorVotacao() {
    return topicoService.listarTopicosPorVotacao();
  }

  @GetMapping("/topico/buscarPorId/{id}")
  public TopicoDTO listar(@PathVariable Long id) {
    return topicoService.buscarPorId(id);
  }

  // ---

  // Tecnologias
  @GetMapping("/tecnologias/listar/{tipo}")
  public List<Tecnologias> listarPorTipo(@PathVariable Long tipo) {
    return tecnologiasService.listarPorTipo(tipo);
  }
  // ---

  // Votação
  @PostMapping("/votacao/votar")
  public Votos votar(@RequestBody VotoDTO voto) {
    return votosService.salvar(voto);
  }

  @PostMapping("/votacao/obterVotoPorTopicoEUsuario")
  public VotoDTO obterVotoPorTopicoEUsuario(@RequestBody VotoDTO voto) {
    return votosService.obterVotoPorTopicoEUsuario(voto);
  }
  // ---

  // Comentário
  @PostMapping("/comentario/salvarComentario")
  public Comentario salvarComentario(@RequestBody ComentarioParaSalvarDTO comentario) {
    return comentarioService.salvarComentario(comentario);
  }

  @GetMapping("/comentario/listarPorTopico/{idTopico}")
  public List<Comentario> listarPorTopico(@PathVariable String idTopico) {
    return comentarioService.listarPorTopico(idTopico);
  }

  // ---

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
