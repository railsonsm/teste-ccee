package com.ccee.teste.model.request;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.ccee.teste.model.Regiao;
import com.ccee.teste.model.Valor;
import com.ccee.teste.model.ValorTipoEnum;

public class ValorRequest {
   private List<String> valor;

   public List<Valor> toValor(ValorTipoEnum tipo, Regiao regiao) {

      return valor.stream().map(v -> {
         Valor valorSave = new Valor();
         valorSave.setRegiao(regiao);
         valorSave.setTipo(tipo);
         valorSave.setValor(new BigDecimal(v));
         return valorSave;
      }).collect(Collectors.toList());
   }

   public List<String> getValor() {
      return this.valor;
   }

   public void setValor(List<String> valor) {
      this.valor = valor;
   }

}
