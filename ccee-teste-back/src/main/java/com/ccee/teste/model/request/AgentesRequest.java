package com.ccee.teste.model.request;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccee.teste.model.Agente;
import com.fasterxml.jackson.databind.ObjectMapper;

@XmlRootElement(name = "agentes")
public class AgentesRequest {
   private List<AgenteRequest> agente;
   private String versao;

   public List<Agente> toAgentes(){
      return agente.stream().map(a -> {
          Agente ag = a.toAgente();
          ag.setVersao(versao);
          return ag;
      }).collect(Collectors.toList());
   }

   public List<AgenteRequest> getAgente() {
      return this.agente;
   }

   public void setAgente(List<AgenteRequest> agente) {
      this.agente = agente;
   }

   @XmlAttribute
   public String getVersao() {
      return this.versao;
   }

   public void setVersao(String versao) {
      this.versao = versao;
   }

   @Override
   public String toString() {
      try {
         ObjectMapper mapper = new ObjectMapper();
         return mapper.writeValueAsString(this);
      } catch (Exception e) {
         return super.toString();
      }
   }

}
