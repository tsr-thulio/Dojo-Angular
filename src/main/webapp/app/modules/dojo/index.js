//Here we will create the angular module called 'TechGallery.Dojo', with no injects.
//when we create this module, everything the we create in him like services, factory,
//directives, controllers and configurations must be specified.
//For this example we need two controllers, one service and one config.
angular
  .module('yourModule', [])
  // .service('DojoService', require('./services/DojoService'))
  // .controller('SearchDojoController', require('./controllers/SearchDojoController'))
  // .controller('AddDojoController', require('./controllers/AddDojoController'))
  // .config(require('./routes'));

module.exports = 'yourModule';
