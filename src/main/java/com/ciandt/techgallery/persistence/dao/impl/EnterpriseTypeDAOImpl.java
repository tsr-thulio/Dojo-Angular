package com.ciandt.techgallery.persistence.dao.impl;

import com.ciandt.techgallery.persistence.dao.EnterpriseTypeDAO;
import com.ciandt.techgallery.persistence.model.EnterpriseType;

/**
 * TechnologyDAOImpl methods implementation.
 *
 * @author Felipe Goncalves de Castro
 *
 */
public class EnterpriseTypeDAOImpl extends GenericDAOImpl<EnterpriseType, Long>implements EnterpriseTypeDAO {

  /*
   * Attributes --------------------------------------------
   */
  private static EnterpriseTypeDAOImpl instance;

  /*
   * Constructor --------------------------------------------
   */
  private EnterpriseTypeDAOImpl() {
  }

  /**
   * Singleton method for the DAO.
   *
   * @author <a href="mailto:joaom@ciandt.com"> João Felipe de Medeiros
   *         Moreira </a>
   * @since 08/10/2015
   *
   * @return TechnologyDAOImpl instance.
   */
  public static EnterpriseTypeDAOImpl getInstance() {
    if (instance == null) {
      instance = new EnterpriseTypeDAOImpl();
    }
    return instance;
  }

}
