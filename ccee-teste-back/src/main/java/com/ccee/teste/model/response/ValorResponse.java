package com.ccee.teste.model.response;

import java.math.BigDecimal;
import java.util.List;

public class ValorResponse {
   private String tipo;

   private List<BigDecimal> valores;

   public ValorResponse(String tipo, List<BigDecimal> valores) {
      this.tipo = tipo;
      this.valores = valores;
   }

   public String getTipo() {
      return this.tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public List<BigDecimal> getValores() {
      return this.valores;
   }

   public void setValores(List<BigDecimal> valores) {
      this.valores = valores;
   }

}
