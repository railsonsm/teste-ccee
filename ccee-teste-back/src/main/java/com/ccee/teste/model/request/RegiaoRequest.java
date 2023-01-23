package com.ccee.teste.model.request;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.ccee.teste.model.Agente;
import com.ccee.teste.model.Regiao;
import com.ccee.teste.model.TipoSiglaEnum;
import com.ccee.teste.model.Valor;
import com.ccee.teste.model.ValorTipoEnum;

public class RegiaoRequest {
   private ValorRequest geracao;
   private ValorRequest compra;
   private ValorRequest precoMedio;
   private String sigla;

   public Regiao toRegiao(Agente agente) {
      Regiao regiao = new Regiao();
      List<Valor> valores = new ArrayList<>();
      regiao.setSigla(TipoSiglaEnum.getTipoSiglaEnumByName(sigla));
      if (geracao != null)
         valores.addAll(geracao.toValor(ValorTipoEnum.GERACAO, regiao));
      if (compra != null)
         valores.addAll(compra.toValor(ValorTipoEnum.COMPRA, regiao));
      
      regiao.setValores(valores);
      regiao.setAgente(agente);
      return regiao;
   }

   public ValorRequest getGeracao() {
      return geracao;
   }

   public void setGeracao(ValorRequest value) {
      this.geracao = value;
   }

   public ValorRequest getCompra() {
      return compra;
   }

   public void setCompra(ValorRequest value) {
      this.compra = value;
   }

   public ValorRequest getPrecoMedio() {
      return precoMedio;
   }

   public void setPrecoMedio(ValorRequest value) {
      this.precoMedio = value;
   }

   @XmlAttribute
   public String getSigla() {
      return sigla;
   }

   public void setSigla(String value) {
      this.sigla = value;
   }
}
