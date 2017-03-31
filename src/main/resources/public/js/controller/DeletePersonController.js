'use strict';

app.controller('DeletePersonController', ['$scope', 'Person', '$location', '$routeParams', function($scope, Person, $location, $routeParams) {

    $scope.personId = $routeParams.id;
    Person.delete({id:$scope.personId}, function () {
        $location.path("/person");
    });


}]);