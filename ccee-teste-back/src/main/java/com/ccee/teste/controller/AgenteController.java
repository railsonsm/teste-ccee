package com.ccee.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccee.teste.model.Agente;
import com.ccee.teste.model.response.AgenteResponse;
import com.ccee.teste.model.response.GraficoResponse;
import com.ccee.teste.repository.projection.ProjectionGrafico;
import com.ccee.teste.service.AgenteService;

@RestController
@RequestMapping("/agentes")
public class AgenteController {
   @Autowired
   private AgenteService agenteService;

   @GetMapping
   public ResponseEntity<List<AgenteResponse>> listAll() {

      return ResponseEntity.ok(agenteService.listarTodos());
   }

   @GetMapping("/grafico")
   public ResponseEntity<GraficoResponse> grafico() {

      return ResponseEntity.ok(agenteService.grafico());
   }
}
