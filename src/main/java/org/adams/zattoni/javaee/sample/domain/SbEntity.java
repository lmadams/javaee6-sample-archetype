package org.adams.zattoni.javaee.sample.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SB")
@NamedQueries({
  @NamedQuery(name = "SbEntity.findAll", query = "SELECT s FROM SbEntity s"),
  @NamedQuery(
    name = "SbEntity.findByIdRegiao",
    query = "SELECT s FROM SbEntity s WHERE s.idRegiao = :idRegiao"
  ),
  @NamedQuery(
    name = "SbEntity.findByIdRegiaoAndDescricao",
    query =
        "SELECT s FROM SbEntity s WHERE s.idRegiao = :idRegiao and UPPER(s.descricao) = UPPER(:descricaoSb)"
  )
})
@Data
public class SbEntity implements Serializable {

  private static final long serialVersionUID = -1125862778842861435L;

  @Id
  @SequenceGenerator(name = "SQ_SB_GENERATOR", sequenceName = "SQ_SB", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_SB_GENERATOR")
  @Column(name = "ID_SB")
  private Long id;

  private String descricao;

  @Column(name = "ID_REGIAO")
  private Long idRegiao;

  private BigDecimal latitude;

  private BigDecimal longitude;
}
