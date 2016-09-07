'use strict';

var interceptor = require('rest/interceptor');

module.exports = interceptor({
  request: function (request) {
    if (request.path.indexOf('{') !== -1) {
      request.path = request.path.split('{')[0];
    }
    return request;
  }
});
