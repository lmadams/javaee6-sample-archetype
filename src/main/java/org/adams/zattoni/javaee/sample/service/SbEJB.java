package org.adams.zattoni.javaee.sample.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.adams.zattoni.javaee.sample.domain.SbEntity;

@Stateless
public class SbEJB {

  @PersistenceContext(unitName = "antifraudes")
  private EntityManager em;

  public SbEntity create(final SbEntity sbEntity) {
    em.persist(sbEntity);
    return sbEntity;
  }
}
