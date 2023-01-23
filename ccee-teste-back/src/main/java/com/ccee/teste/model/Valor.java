package com.ccee.teste.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Valor {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated(EnumType.STRING)
   private ValorTipoEnum tipo;

   private BigDecimal valor;

   @JsonIgnore
   @JoinColumn(name = "regiao_id")
   @ManyToOne
   private Regiao regiao;


   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public ValorTipoEnum getTipo() {
      return this.tipo;
   }

   public void setTipo(ValorTipoEnum tipo) {
      this.tipo = tipo;
   }

   public Regiao getRegiao() {
      return this.regiao;
   }

   public void setRegiao(Regiao regiao) {
      this.regiao = regiao;
   }


   public BigDecimal getValor() {
      return this.valor;
   }

   public void setValor(BigDecimal valor) {
      this.valor = valor;
   }
   
   public Valor getThis(){
      return this;
   }

}
