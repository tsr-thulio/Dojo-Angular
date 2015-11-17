package com.ciandt.techgallery.service.enums;

/**
 * Enum for mapping Date Filters.
 * 
 * @author Thulio Ribeiro
 *
 */
public enum EnterpriseEmployeeRangeEnum {

  UP_TO_10("Up to 10 employees", 0, 10), BETWEEN_10_50("Between 10 and 50 employees", 10, 50),
  BETWEEN_50_100("Between 50 and 100 Employees", 50, 100), MORE_THAN_100("More than 100 employees", 100, Integer.MAX_VALUE);

  private String message;
  private Integer minValue;
  private Integer maxValue;

  private EnterpriseEmployeeRangeEnum(String message, Integer minValue, Integer maxValue) {
    this.message = message;
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getMinValue() {
    return minValue;
  }

  public void setMinValue(Integer minValue) {
    this.minValue = minValue;
  }

  public Integer getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(Integer maxValue) {
    this.maxValue = maxValue;
  }

}
