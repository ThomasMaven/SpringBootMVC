'use strict';

app.controller('AddContactController', ['$scope', 'Person', '$location', '$routeParams', function($scope, Person, $location, $routeParams) {

    $scope.personId = $routeParams.personId;
    $scope.saveContact = function(){
        var contact = new Person({
              value : $scope.value,
              type : $scope.type
        })
        contact.$addContact({id:$scope.personId}, function () {
            $location.path("/person");
        });
    };

}]);