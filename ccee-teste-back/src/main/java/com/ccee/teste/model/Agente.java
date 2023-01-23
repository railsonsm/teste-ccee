package com.ccee.teste.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Agente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String codigo;

   private String versao;

   private LocalDateTime data;

   @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL)
   private List<Regiao> regioes;

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getCodigo() {
      return this.codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public String getVersao() {
      return this.versao;
   }

   public void setVersao(String versao) {
      this.versao = versao;
   }


   public LocalDateTime getData() {
      return this.data;
   }

   public void setData(LocalDateTime data) {
      this.data = data;
   }


   public List<Regiao> getRegioes() {
      return this.regioes;
   }

   public void setRegioes(List<Regiao> regioes) {
      this.regioes = regioes;
   }
   
}
