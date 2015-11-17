package com.ciandt.techgallery.service.model;

import java.util.List;

/**
 * Response with a technology entity.
 *
 * @author tribeiro
 *
 */
public class EnterpriseTO implements Response {

  private Long cnpj;

  private String name;

  private String website;

  private Integer employeeNumber;

  private List<String> enterpriseType;

  public Long getCnpj() {
    return cnpj;
  }

  public void setCnpj(Long cnpj) {
    this.cnpj = cnpj;
  }

  public String getName() {
    return name;
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
