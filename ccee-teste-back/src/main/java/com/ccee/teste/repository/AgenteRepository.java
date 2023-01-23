package com.ccee.teste.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ccee.teste.model.Agente;
import com.ccee.teste.repository.projection.ProjectionGrafico;

public interface AgenteRepository extends JpaRepository<Agente, Long> {

   @Query(value = "select sum(v.valor) valor, r.sigla, year(a.data) ano from regiao r join valor v " +
   "on v.regiao_id = r.id " +
   "join agente a on a.id = r.agente_id  where a.data BETWEEN :anoInicio and now()    " +
   "group by r.sigla, year(a.data)", nativeQuery = true) 
   public List<ProjectionGrafico> getDadosGrafico(LocalDateTime anoInicio);
}
