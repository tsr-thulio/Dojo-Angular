angular
  .module('TechGallery.Auth', [])
  .service('AuthService', require('./services/AuthService'))
  .directive('login', require('./directives/LoginDirective'))
  .constant('CLIENT_ID', '327024247170-p1dsggu7d146ihi5qkm881b462i3agsm.apps.googleusercontent.com')
  .constant('USER_SCOPES', 'https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/userinfo.email');

module.exports = 'TechGallery.Auth';
