module.exports = function ($q) {
	/**
   * Object context
   * @type {Object}
   */
   var context = this;

   this.getAllEnterprises = function(){
   	var deferred = $q.defer();
   	gapi.client.rest.findAllEnterprises().execute(function(data){
   		deferred.resolve(data);
   	});
   	return deferred.promise;
   }

   this.findByFilter = function(enterpriseName, employeeSelected, enterpriseTypes){
	var deferred = $q.defer();
   	var req = {
		nameContains: enterpriseName,
		employeesRange: employeeSelected!=""?employeeSelected:undefined,
		enterpriseTypes: enterpriseTypes
	}
	gapi.client.rest.findEnterpriseByFilter(req).execute(function(data){
		deferred.resolve(data);
	});
	return deferred.promise;
   }

   this.getEnterpriseTypes = function(){
   	var deferred = $q.defer();
   	gapi.client.rest.getEnterpriseTypes().execute(function(data){
   		deferred.resolve(data);
   	});
   	return deferred.promise;
   }

   this.addEnterprise = function(name, employeesNumber, types, website, cnpj){
      var deferred = $q.defer();
      var req = {
         name: name,
         employeeNumber: employeesNumber,
         enterpriseType: types,
         website: website,
         cnpj: cnpj
      }
      gapi.client.rest.addEnterprise(req).execute(function(data){
         deferred.resolve(data);
      });
      return deferred.promise;
   };

	this.EmployeesRangeEnum = {
	    UP_TO_10: {name: 'UP_TO_10', message: 'Up to 10 employees', minValue: 0, maxValue: 10},
	    BETWEEN_10_50: {name: 'BETWEEN_10_50', message: 'Between 10 and 50 employees', minValue: 10, maxValue: 50},
	    BETWEEN_50_100: {name: 'BETWEEN_50_100', message: 'Between 50 and 100 Employees', minValue: 50, maxValue: 100},
	    MORE_THAN_100: {name: 'MORE_THAN_100', message: 'More than 100 employees', minValue: 0, maxValue: 100}
	}
};
