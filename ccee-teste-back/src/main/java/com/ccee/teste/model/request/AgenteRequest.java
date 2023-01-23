package com.ccee.teste.model.request;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ccee.teste.model.Agente;
import com.ccee.teste.util.DataUtil;

public class AgenteRequest {
   private String codigo;

   private Date data;

   private List<RegiaoRequest> regiao;
   
   public Agente toAgente(){
 
      Agente agente = new Agente();
      agente.setCodigo(codigo);
      agente.setData(DataUtil.asLocalDateTime(data));
      if(regiao != null){
         agente.setRegioes(regiao.stream().map(r -> r.toRegiao(agente)).collect(Collectors.toList()));
      }
      return agente;
   }

   public String getCodigo() {
      return this.codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }


   public Date getData() {
      return this.data;
   }

   public void setData(Date data) {
      this.data = data;
   }
   

   public List<RegiaoRequest> getRegiao() {
      return this.regiao;
   }

   public void setRegiao(List<RegiaoRequest> regiao) {
      this.regiao = regiao;
   }

}
