//remember to inject all dependecies that you will use
module.exports = function (AppService) {

  var context = this;

  //In this controller we need a method to get all the enterprises in database to fill the table in view,
  //a method to find the enterprises according the filters selected and update view,
  //a method to get all possibles enterprise types to create the dynamic checkboxes,
  //a method to get informations for populate the dropdown employee range,
  //a method to clear the filters and reset the search.

  /**
   * Page title
   */
   AppService.setPageTitle('Dojo - Angular');
 }