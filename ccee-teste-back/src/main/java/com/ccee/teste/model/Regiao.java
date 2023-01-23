package com.ccee.teste.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Regiao {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated(EnumType.STRING)
   private TipoSiglaEnum sigla;

   @OneToMany(mappedBy = "regiao", cascade = CascadeType.ALL)
   private List<Valor> valores;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "agente_id")
   private Agente agente;

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

   public List<Valor> getValores() {
      return this.valores;
   }

   public void setValores(List<Valor> valores) {
      this.valores = valores;
   }

   public Agente getAgente() {
      return this.agente;
   }

   public void setAgente(Agente agente) {
      this.agente = agente;
   }

}
