package com.ccee.teste.model;

public enum TipoSiglaEnum {
   S, NE, N, SE;

   public static TipoSiglaEnum getTipoSiglaEnumByName(String name) {
      for (TipoSiglaEnum valor : TipoSiglaEnum.values())
         if (valor.name().equalsIgnoreCase(name.trim().toLowerCase()))
            return valor;
      return null;
   }
}
