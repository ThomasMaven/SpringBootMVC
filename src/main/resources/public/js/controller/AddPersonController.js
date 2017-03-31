'use strict';

app.controller('AddPersonController', ['$scope', 'Person', '$location', function($scope, Person, $location) {
    $scope.savePerson = function(){

        var person = new Person({
            name : $scope.name,
            surname : $scope.surname
        })
        person.$save(function () {
            $location.path("/person");
        });
    };

}]);