'use strict';

app.controller('PersonListController', ['$scope', 'Person', function($scope, Person) {
          var PersonList=[];
          var fetchAllPerson = function(){
        	  $scope.PersonList = Person.query();
          };
          fetchAllPerson();
}]);