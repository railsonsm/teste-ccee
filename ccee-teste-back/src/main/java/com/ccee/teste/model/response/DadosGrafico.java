package com.ccee.teste.model.response;

import java.util.List;

public class DadosGrafico {
   private String sigla;
   private List<Double> valores; 

   public DadosGrafico(String sigla, List<Double> valores){
      this.sigla = sigla;
      this.valores = valores;
   }

   public String getSigla() {
      return this.sigla;
   }

   public void setSigla(String sigla) {
      this.sigla = sigla;
   }

  

   public List<Double> getValores() {
      return this.valores;
   }

   public void setValores(List<Double> valores) {
      this.valores = valores;
   }

}
