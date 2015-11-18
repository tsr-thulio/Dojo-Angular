module.exports = function(
  $stateProvider,
  $urlRouterProvider
) {

  /**
   * Views folder for the controller
   * @type {String}
   */
  var viewsFolder = 'app/modules/dojo/views/';

  //In urlRouterProvider we tell to angular where he need to go when some url is requested.
  //the signature is '.when('url comming', 'url to go')' its easy no?! Exact... exact... exact!
  $urlRouterProvider
  .when('/deLáPraCá', '/deCáPraLá');

  $stateProvider
  //The state provider create the states to be redirected, he is composed by a name of the state
  //and a object with your url, controller, and templateUrl that is the path of your html.
    .state('root.stateName', {
      url: '/state',
      controller: 'YourController as yourAlias',
      templateUrl: 'path of html'
    })
};