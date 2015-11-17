package com.ciandt.techgallery.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.ciandt.techgallery.persistence.model.Enterprise;
import com.ciandt.techgallery.persistence.model.EnterpriseType;
import com.ciandt.techgallery.service.model.EnterpriseFilter;
import com.google.api.server.spi.response.BadRequestException;
import com.google.appengine.api.users.User;

/**
 * Services for Technologies.
 *
 * @author tribeiro
 *
 */
public interface EnterpriseService {

  public Enterprise addEnterprise(Enterprise enterprise, User user)
      throws BadRequestException, IOException, GeneralSecurityException;

  public List<Enterprise> findAllEnterprises(User user)
      throws BadRequestException, IOException, GeneralSecurityException;

  public List<Enterprise> findByFilter(EnterpriseFilter filter, User user)
      throws BadRequestException, IOException, GeneralSecurityException;

  public List<EnterpriseType> getEnterpriseTypes(User user);

  public EnterpriseType addEnterpriseType(EnterpriseType enterpriseType, User user);
}
