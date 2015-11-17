package com.ciandt.techgallery.service.transformer;

import com.ciandt.techgallery.persistence.model.EnterpriseType;
import com.ciandt.techgallery.service.model.EnterpriseTypeTO;
import com.google.api.server.spi.config.Transformer;

public class EnterpriseTypeTransformer implements Transformer<EnterpriseType, EnterpriseTypeTO> {

  @Override
  public EnterpriseType transformFrom(EnterpriseTypeTO baseObject) {
    EnterpriseType enterprise = new EnterpriseType();
    enterprise.setName(baseObject.getName());
    enterprise.setDescription(baseObject.getDescription());
    return enterprise;
  }

  @Override
  public EnterpriseTypeTO transformTo(EnterpriseType baseObject) {
    if (baseObject.getInactivatedDate() == null) {
      EnterpriseTypeTO enterpriseTO = new EnterpriseTypeTO();
      enterpriseTO.setName(baseObject.getName());
      enterpriseTO.setDescription(baseObject.getDescription());
      return enterpriseTO;
    } else {
      return null;
    }
  }

}
