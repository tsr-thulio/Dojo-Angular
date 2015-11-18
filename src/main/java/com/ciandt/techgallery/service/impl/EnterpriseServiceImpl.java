package com.ciandt.techgallery.service.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import com.ciandt.techgallery.persistence.dao.EnterpriseDAO;
import com.ciandt.techgallery.persistence.dao.EnterpriseTypeDAO;
import com.ciandt.techgallery.persistence.dao.impl.EnterpriseDAOImpl;
import com.ciandt.techgallery.persistence.dao.impl.EnterpriseTypeDAOImpl;
import com.ciandt.techgallery.persistence.model.Enterprise;
import com.ciandt.techgallery.persistence.model.EnterpriseType;
import com.ciandt.techgallery.service.EnterpriseService;
import com.ciandt.techgallery.service.UserServiceTG;
import com.ciandt.techgallery.service.model.EnterpriseFilter;
import com.google.api.server.spi.response.BadRequestException;
import com.google.appengine.api.users.User;

public class EnterpriseServiceImpl implements EnterpriseService {

  /*
   * Attributes --------------------------------------------
   */
  private static EnterpriseServiceImpl instance;

  /** tech gallery user service. */
  UserServiceTG userService = UserServiceTGImpl.getInstance();
  EnterpriseDAO enterpriseDAO = EnterpriseDAOImpl.getInstance();
  EnterpriseTypeDAO enterpriseTypeDAO = EnterpriseTypeDAOImpl.getInstance();

  /*
   * Constructors --------------------------------------------
   */
  private EnterpriseServiceImpl() {
  }

  /**
   * Singleton method for the service.
   *
   * @author <a href="mailto:joaom@ciandt.com"> João Felipe de Medeiros
   *         Moreira </a>
   * @since 07/10/2015
   *
   * @return TechnologyServiceImpl instance.
   */
  public static EnterpriseServiceImpl getInstance() {
    if (instance == null) {
      instance = new EnterpriseServiceImpl();
    }
    return instance;
  }

  /*
   * Methods --------------------------------------------
   */
  @Override
  public Enterprise addEnterprise(Enterprise enterprise, User user)
      throws BadRequestException, IOException, GeneralSecurityException {

    enterpriseDAO.add(enterprise);

    return enterprise;
  }

  @Override
  public List<Enterprise> findAllEnterprises(User user) {
    List<Enterprise> enterprises = enterpriseDAO.findAll();
    if (enterprises == null) {
      enterprises = new ArrayList<>();
    }
    return enterprises;
  }

  @Override
  public List<Enterprise> findByFilter(EnterpriseFilter filter, User user)
      throws BadRequestException, IOException, GeneralSecurityException {

    List<Enterprise> completeList = new ArrayList<>();
    List<Enterprise> filteredList = new ArrayList<>();

    if (filter.getEmployeesRange() != null) {
      completeList = enterpriseDAO.findByEmployeeRange(filter.getEmployeesRange().getMinValue(),
          filter.getEmployeesRange().getMaxValue());
      if (filter.getNameContains() == null
          && (filter.getEnterpriseTypes() == null || filter.getEnterpriseTypes().isEmpty())) {
        return completeList;
      }
    } else {
      completeList = this.findAllEnterprises(user);
    }

    for (Enterprise currentItem : completeList) {
      if (filter.getNameContains() != null && currentItem.getName().toLowerCase().contains(filter.getNameContains().toLowerCase())) {
        if (filter.getEnterpriseTypes() != null && !filter.getEnterpriseTypes().isEmpty()) {
          if (currentItem.getEnterpriseType() != null) {
            Boolean addItem = true;
            for (String type : filter.getEnterpriseTypes()) {
              if (!currentItem.getEnterpriseType().contains(type)) {
                addItem = false;
                break;
              }
            }
            if (addItem) {
              filteredList.add(currentItem);
            }
          }
        } else {
          filteredList.add(currentItem);
        }
      } else if (filter.getEnterpriseTypes() != null && !filter.getEnterpriseTypes().isEmpty()) {
        if (currentItem.getEnterpriseType() != null) {
          Boolean addItem = true;
          for (String type : filter.getEnterpriseTypes()) {
            if (!currentItem.getEnterpriseType().contains(type)) {
              addItem = false;
              break;
            }
          }
          if (addItem) {
            filteredList.add(currentItem);
          }
        }
      }
    }
    return filteredList;
  }

  @Override
  public List<EnterpriseType> getEnterpriseTypes(User user) {
    return enterpriseTypeDAO.findAll();
  }

  @Override
  public EnterpriseType addEnterpriseType(EnterpriseType enterpriseType, User user) {
    enterpriseTypeDAO.add(enterpriseType);
    return enterpriseType;
  }
}
