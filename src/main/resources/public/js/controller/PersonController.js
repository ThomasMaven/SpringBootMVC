'use strict';

app.controller('PersonController', ['$scope', 'Person', '$routeParams', function($scope, Person, $routeParams) {
          var personId = $routeParams.id;
          var fetchAllPerson = function(){
        	  $scope.person = Person.get({id:personId});
          };
          fetchAllPerson();
}]);