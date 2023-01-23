package com.ccee.teste.model.response;

import java.util.List;
import java.util.Set;

public class GraficoResponse {
   private Set<String> ano;
   private List<DadosGrafico> dados;

   public Set<String> getAno() {
      return this.ano;
   }

   public void setAno(Set<String> ano) {
      this.ano = ano;
   }

   public List<DadosGrafico> getDados() {
      return this.dados;
   }

   public void setDados(List<DadosGrafico> dados) {
      this.dados = dados;
   }

}
