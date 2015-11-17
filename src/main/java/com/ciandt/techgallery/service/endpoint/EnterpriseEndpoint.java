package com.ciandt.techgallery.service.endpoint;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.ciandt.techgallery.Constants;
import com.ciandt.techgallery.persistence.model.Enterprise;
import com.ciandt.techgallery.persistence.model.EnterpriseType;
import com.ciandt.techgallery.service.EnterpriseService;
import com.ciandt.techgallery.service.impl.EnterpriseServiceImpl;
import com.ciandt.techgallery.service.model.EnterpriseFilter;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.BadRequestException;
import com.google.api.server.spi.response.InternalServerErrorException;
import com.google.appengine.api.users.User;

/**
 * Endpoint controller class for Technology requests.
 *
 * @author tribeiro
 *
 */
@Api(name = "rest", version = "v1", clientIds = { Constants.WEB_CLIENT_ID,
    Constants.API_EXPLORER_CLIENT_ID }, scopes = { Constants.EMAIL_SCOPE, Constants.PLUS_SCOPE,
        Constants.PLUS_STREAM_WRITE })
public class EnterpriseEndpoint {

  private EnterpriseService service = EnterpriseServiceImpl.getInstance();

  @ApiMethod(name = "addEnterprise", path = "enterprise", httpMethod = "post")
  public Enterprise addEnterprise(Enterprise enterprise, User user)
      throws InternalServerErrorException, BadRequestException, IOException, GeneralSecurityException {
    return service.addEnterprise(enterprise, user);
  }

  @ApiMethod(name = "findAllEnterprises", path = "enterprise/findAll", httpMethod = "get")
  public List<Enterprise> findAllEnterprises(User user)
      throws InternalServerErrorException, BadRequestException, IOException, GeneralSecurityException {
    return service.findAllEnterprises(user);
  }

  @ApiMethod(name = "findEnterpriseByFilter", path = "enterprise/search", httpMethod = "post")
  public List<Enterprise> findEnterpriseByFilter(EnterpriseFilter filter, User user)
      throws InternalServerErrorException, BadRequestException, IOException, GeneralSecurityException {
    return service.findByFilter(filter, user);
  }

  @ApiMethod(name = "getEnterpriseTypes", path = "enterpriseType", httpMethod = "get")
  public List<EnterpriseType> getEnterpriseTypes(User user)
      throws InternalServerErrorException, BadRequestException, IOException, GeneralSecurityException {
    return service.getEnterpriseTypes(user);
  }

  @ApiMethod(name = "addEnterpriseType", path = "addEnterpriseType", httpMethod = "post")
  public EnterpriseType addEnterpriseType(EnterpriseType enterpriseType, User user)
      throws InternalServerErrorException, BadRequestException, IOException, GeneralSecurityException {
    return service.addEnterpriseType(enterpriseType, user);
  }

}
