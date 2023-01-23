package com.ccee.teste.model;

public enum ValorTipoEnum {
   GERACAO("geracao"), COMPRA("compra"), PRECO_MEDIO("precoMedio");

   private String nome;

   public ValorTipoEnum getValorTipoEnumByName(String name) {
      for (ValorTipoEnum valor : ValorTipoEnum.values())
         if (valor.name().equalsIgnoreCase(name.trim().toLowerCase()))
            return valor;
      return null;
   }

   private ValorTipoEnum(String nome) {
      this.nome = nome;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

}
