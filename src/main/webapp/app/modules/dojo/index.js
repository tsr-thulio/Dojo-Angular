angular
  .module('TechGallery.Dojo', [])
  .service('DojoService', require('./services/DojoService'))
  .controller('SearchDojoController', require('./controllers/SearchDojoController'))
  .controller('AddDojoController', require('./controllers/AddDojoController'))
  .config(require('./routes'));

module.exports = 'TechGallery.Dojo';
