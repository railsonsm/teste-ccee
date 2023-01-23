package com.ccee.teste.model.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ccee.teste.model.Agente;

public class AgenteResponse {

   private Long id;

   private String codigo;

   private String versao;

   private LocalDateTime data;

   private List<RegiaoResponse> regioes;

   public AgenteResponse(Agente agente) {
      this.id = agente.getId();
      this.codigo = agente.getCodigo();
      this.versao = agente.getVersao();
      this.data = agente.getData();
      this.regioes = agente.getRegioes().stream().map(RegiaoResponse::new).collect(Collectors.toList());
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getCodigo() {
      return this.codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public String getVersao() {
      return this.versao;
   }

   public void setVersao(String versao) {
      this.versao = versao;
   }

   public LocalDateTime getData() {
      return this.data;
   }

   public void setData(LocalDateTime data) {
      this.data = data;
   }

   public List<RegiaoResponse> getRegioes() {
      return this.regioes;
   }

   public void setRegioes(List<RegiaoResponse> regioes) {
      this.regioes = regioes;
   }

}
