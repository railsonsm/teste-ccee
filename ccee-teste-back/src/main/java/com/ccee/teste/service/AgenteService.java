package com.ccee.teste.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccee.teste.model.Agente;
import com.ccee.teste.model.response.AgenteResponse;
import com.ccee.teste.model.response.DadosGrafico;
import com.ccee.teste.model.response.GraficoResponse;
import com.ccee.teste.repository.AgenteRepository;
import com.ccee.teste.repository.projection.ProjectionGrafico;

@Service
public class AgenteService {
   
   @Autowired
   private AgenteRepository agenteRepository;

   public void salvar(List<Agente> agentes) {
      agenteRepository.saveAll(agentes);
   }

   public List<AgenteResponse> listarTodos() {
      return agenteRepository.findAll().stream().map(AgenteResponse::new).collect(Collectors.toList());
   }

   public GraficoResponse grafico() {
      GraficoResponse response = new GraficoResponse();
      List<ProjectionGrafico> dadosGrafico = agenteRepository.getDadosGrafico(LocalDateTime.now().minusYears(10));
      Map<String, List<ProjectionGrafico>> list = dadosGrafico.stream()
            .collect(Collectors.groupingBy(ProjectionGrafico::getSigla));
            
      response.setAno(dadosGrafico.stream().map(ProjectionGrafico::getAno).collect(Collectors.toSet()));
      response.setDados(list.entrySet().stream().map(es -> new DadosGrafico(es.getKey(),
      es.getValue().stream().map(ProjectionGrafico::getValor).collect(Collectors.toList()))).collect(Collectors.toList()));
      return response;
   }
}
