package com.ciandt.techgallery.service.model;

import java.util.List;

import com.ciandt.techgallery.service.enums.EnterpriseEmployeeRangeEnum;

/**
 * Response with all technology entities.
 * 
 * @author Thulio Ribeiro
 *
 */
public class EnterpriseFilter implements Response {

  private String nameContains;

  private EnterpriseEmployeeRangeEnum employeesRange;

  private List<String> enterpriseTypes;

  public String getNameContains() {
    return nameContains;
  }

  public List<String> getEnterpriseTypes() {
    return enterpriseTypes;
  }

  public void setEnterpriseTypes(List<String> enterpriseTypes) {
    this.enterpriseTypes = enterpriseTypes;
  }

  public void setNameContains(String nameContains) {
    this.nameContains = nameContains;
  }

  public EnterpriseEmployeeRangeEnum getEmployeesRange() {
    return employeesRange;
  }

  public void setEmployeesRange(EnterpriseEmployeeRangeEnum employeesRange) {
    this.employeesRange = employeesRange;
  }

}
