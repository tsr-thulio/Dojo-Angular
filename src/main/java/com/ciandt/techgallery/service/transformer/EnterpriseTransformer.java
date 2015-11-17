package com.ciandt.techgallery.service.transformer;

import com.ciandt.techgallery.persistence.model.Enterprise;
import com.ciandt.techgallery.service.model.EnterpriseTO;
import com.google.api.server.spi.config.Transformer;

public class EnterpriseTransformer implements Transformer<Enterprise, EnterpriseTO> {

  @Override
  public Enterprise transformFrom(EnterpriseTO baseObject) {
    Enterprise enterprise = new Enterprise();
    enterprise.setCnpj(baseObject.getCnpj());
    enterprise.setName(baseObject.getName());
    enterprise.setEmployeeNumber(baseObject.getEmployeeNumber());
    enterprise.setWebsite(baseObject.getWebsite());
    enterprise.setEnterpriseType(baseObject.getEnterpriseType());
    return enterprise;
  }

  @Override
  public EnterpriseTO transformTo(Enterprise baseObject) {
    if (baseObject.getInactivatedDate() == null) {
      EnterpriseTO enterpriseTO = new EnterpriseTO();
      enterpriseTO.setCnpj(baseObject.getCnpj());
      enterpriseTO.setName(baseObject.getName());
      enterpriseTO.setEmployeeNumber(baseObject.getEmployeeNumber());
      enterpriseTO.setWebsite(baseObject.getWebsite());
      enterpriseTO.setEnterpriseType(baseObject.getEnterpriseType());
      return enterpriseTO;
    } else {
      return null;
    }
  }

}
