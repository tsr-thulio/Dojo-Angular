//remember to inject all dependecies that you will use
module.exports = function (AppService) {

  var context = this;

  //In this controller we need a method to get all possibles enterprise types to populate the dynamic checkboxes,
  //a method to clean the form, and a a method to add a new enterprise and when this method return success 
  //the user need to be redirected to home page.

  /**
   * Page title
   */
   AppService.setPageTitle('Dojo - Angular');
 }