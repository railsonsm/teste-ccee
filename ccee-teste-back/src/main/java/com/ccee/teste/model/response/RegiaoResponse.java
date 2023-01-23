package com.ccee.teste.model.response;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ccee.teste.model.Regiao;
import com.ccee.teste.model.TipoSiglaEnum;
import com.ccee.teste.model.Valor;
import com.ccee.teste.model.ValorTipoEnum;

public class RegiaoResponse {

   private Long id;
   private TipoSiglaEnum sigla;
   private List<ValorResponse> valores;

   public RegiaoResponse(Regiao regiao) {
      this.id = regiao.getId();
      this.sigla = regiao.getSigla();

      Map<ValorTipoEnum, List<Valor>> list = regiao.getValores().stream()
            .collect(Collectors.groupingBy(Valor::getTipo));

      valores = list.entrySet().stream().map(es -> new ValorResponse(es.getKey().getNome(),
            es.getValue().stream().map(Valor::getValor).collect(Collectors.toList()))).collect(Collectors.toList());

   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public TipoSiglaEnum getSigla() {
      return this.sigla;
   }

   public void setSigla(TipoSiglaEnum sigla) {
      this.sigla = sigla;
   }

   public List<ValorResponse> getValores() {
      return this.valores;
   }

   public void setValores(List<ValorResponse> valores) {
      this.valores = valores;
   }

}
