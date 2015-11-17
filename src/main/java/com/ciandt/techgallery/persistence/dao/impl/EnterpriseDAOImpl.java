package com.ciandt.techgallery.persistence.dao.impl;

import java.util.List;

import com.ciandt.techgallery.ofy.OfyService;
import com.ciandt.techgallery.persistence.dao.EnterpriseDAO;
import com.ciandt.techgallery.persistence.model.Enterprise;
import com.googlecode.objectify.Objectify;

/**
 * TechnologyDAOImpl methods implementation.
 *
 * @author Felipe Goncalves de Castro
 *
 */
public class EnterpriseDAOImpl extends GenericDAOImpl<Enterprise, Long>implements EnterpriseDAO {

  /*
   * Attributes --------------------------------------------
   */
  private static EnterpriseDAOImpl instance;

  /*
   * Constructor --------------------------------------------
   */
  private EnterpriseDAOImpl() {
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
  public static EnterpriseDAOImpl getInstance() {
    if (instance == null) {
      instance = new EnterpriseDAOImpl();
    }
    return instance;
  }

  @Override
  public Enterprise findByName(String name) {
    final Objectify objectify = OfyService.ofy();
    Enterprise entity = objectify.load().type(Enterprise.class).filter(Enterprise.NAME, name).first().now();

    return entity;
  }

  @Override
  public List<Enterprise> findByEmployeeRange(Integer minValue, Integer maxValue) {
    final Objectify objectify = OfyService.ofy();
    List<Enterprise> entities = objectify.load().type(Enterprise.class)
        .filter(Enterprise.EMPLOYEE_NUMBER + " >", minValue).filter(Enterprise.EMPLOYEE_NUMBER + " <=", maxValue)
        .list();

    return entities;
  }

  @Override
  public Enterprise findByEnterpriseType(String enterpriseType) {
    final Objectify objectify = OfyService.ofy();
    Enterprise entity = objectify.load().type(Enterprise.class).filter(enterpriseType, Enterprise.ENTERPRISE_TYPE)
        .first().now();

    return entity;
  }
}
