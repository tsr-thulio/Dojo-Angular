module.exports = function(
  $stateProvider,
  $urlRouterProvider
) {

  /**
   * Views folder for the controller
   * @type {String}
   */
  var viewsFolder = 'app/modules/dojo/views/';

  $urlRouterProvider
    .when('', '/dojo')
    .when('/', '/dojo');

  $stateProvider
    .state('root.dojo', {
      url: '/dojo',
      controller: 'SearchDojoController as searchController',
      templateUrl: viewsFolder + 'search-dojo.html'
    })
    .state('root.dojo-add', {
      url: '/dojo/new',
      controller: 'AddDojoController as addController',
      templateUrl: viewsFolder + 'add-dojo.html'
    })
};