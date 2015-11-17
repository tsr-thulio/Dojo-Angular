package com.ciandt.techgallery.persistence.model;

import com.ciandt.techgallery.service.transformer.EnterpriseTypeTransformer;
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
@ApiTransformer(EnterpriseTypeTransformer.class)
public class EnterpriseType extends BaseEntity<Long> {

  public static final String NAME = "name";

  @Id
  Long id;

  @Index
  private String name;

  @Unindex
  private String description;

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

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}