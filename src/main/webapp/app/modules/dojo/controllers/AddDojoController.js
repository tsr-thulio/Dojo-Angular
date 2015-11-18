module.exports = function (AppService, DojoService, $state) {

 /**
   * Object context
   * @type {Object}
   */
  var context = this;

  this.getEnterpriseTypes = function(){
  	DojoService.getEnterpriseTypes().then(function(data){
  		context.enterpriseTypes = data.items;
  	});
  }

  this.cancel = function(){
  	context.enterpriseName = '';
  	context.enterpriseEmployeesNumber = '';
  	$("input:checkbox[name=addType]:checked").each(function(){
	    var element = $(this);
	    element[0].checked=false;
	});
  	context.enterpriseWebsite = '';
  	$state.go('root.dojo');
  };

  this.addEnterprise = function(){
  	var types = [];
  	$("input:checkbox[name=addType]:checked").each(function(){
	    types.push($(this).val());
	});
  	DojoService.addEnterprise(context.enterpriseName, context.enterpriseEmployeesNumber, types, context.enterpriseWebsite, context.enterpriseCnpj).then(function(data){
  		if(!data.hasOwnProperty('error')){
  			context.cancel();
  		}
  	});
  };

  context.getEnterpriseTypes();

  /**
   * Page title
   */
   AppService.setPageTitle('Dojo - Angular');
 }