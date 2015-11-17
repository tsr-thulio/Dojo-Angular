package com.ciandt.techgallery.persistence.dao;

import java.util.List;

import com.ciandt.techgallery.persistence.model.Enterprise;

/**
 * TechnologyDAOImpl methods interface.
 *
 * @author Thulio Soares Ribeiro
 *
 */
public interface EnterpriseDAO extends GenericDAO<Enterprise, Long> {

  public Enterprise findByName(String name);

  public List<Enterprise> findByEmployeeRange(Integer minValue, Integer maxValue);

  public Enterprise findByEnterpriseType(String enterpriseType);

}
