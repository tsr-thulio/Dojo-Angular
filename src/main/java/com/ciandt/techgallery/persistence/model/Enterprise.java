package com.ciandt.techgallery.persistence.model;

import java.util.List;

import com.ciandt.techgallery.service.transformer.EnterpriseTransformer;
import com.google.api.server.spi.config.ApiTransformer;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;

/**
 * Technology entity.
 * 
 * @author tribeiro
 *
 */
@Entity
@ApiTransformer(EnterpriseTransformer.class)
public class Enterprise extends BaseEntity<Long> {

  public static final String NAME = "name";
  public static final String EMPLOYEE_NUMBER = "employeeNumber";
  public static final String ENTERPRISE_TYPE = "enterpriseType";

  @Id
  Long id;

  @Unindex
  Long cnpj;

  @Index
  private String name;

  @Index
  private String website;

  @Index
  private Integer employeeNumber;

  @Index
  private List<String> enterpriseType;

  @Override
  public Long getId() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setId(Long id) {
    // TODO Auto-generated method stub

  }

  public String getName() {
    return name;
  }

  public Long getCnpj() {
    return cnpj;
  }

  public void setCnpj(Long cnpj) {
    this.cnpj = cnpj;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public List<String> getEnterpriseType() {
    return enterpriseType;
  }

  public void setEnterpriseType(List<String> enterpriseType) {
    this.enterpriseType = enterpriseType;
  }

}