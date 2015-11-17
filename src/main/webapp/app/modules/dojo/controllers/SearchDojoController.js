module.exports = function (AppService, DojoService, $scope) {

 	/**
   * Object context
   * @type {Object}
   */
  var context = this;

  this.getAllEnterprises = function(){
  	DojoService.getAllEnterprises().then(function(data){
  		context.enterprises = data.items;
  	});
  }

  this.findByFilter = function(){
  	var enterpriseTypes = [];
	$("input:checkbox[name=type]:checked").each(function(){
	    enterpriseTypes.push($(this).val());
	});
	DojoService.findByFilter(context.enterpriseName, context.employeeSelected, enterpriseTypes).then(function(data){
		context.enterprises = data.items;
	});
  }

  this.getEnterpriseTypes = function(){
  	DojoService.getEnterpriseTypes().then(function(data){
  		context.enterpriseTypes = data.items;
  	});
  }
  
  context.getEnterpriseTypes();

  context.employeeNumberList = DojoService.EmployeesRangeEnum;

  context.getAllEnterprises();

   this.clearFilters = function(){
   	context.enterpriseName = "";
   	context.employeeSelected = "";
   	$("input:checkbox[name=type]:checked").each(function(){
	    var element = $(this);
	    element[0].checked=false;
	});
   	context.getAllEnterprises();
   }


  /**
   * Page title
   */
   AppService.setPageTitle('Dojo - Angular');
 }