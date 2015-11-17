package com.ciandt.techgallery.service.enums;

/**
 * Enum for mapping Date Filters.
 * 
 * @author Thulio Ribeiro
 *
 */
public enum EnterpriseTypesEnum {

  TYPE_ONE("Type one"), TYPE_TWO("Type two"), TYPE_TREE("Type tree"), TYPE_FOUR("Type four"), TYPE_FIVE("Type five");

  private String message;

  private EnterpriseTypesEnum(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
