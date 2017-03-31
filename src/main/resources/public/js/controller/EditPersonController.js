'use strict';

app.controller('EditPersonController', ['$scope', 'Person', '$location', '$routeParams', function($scope, Person, $location, $routeParams) {

    $scope.personId = $routeParams.id;
    var fetchAllPerson = function(){
      $scope.person = Person.get({id:$scope.personId});
    };
    fetchAllPerson();

    $scope.updatePerson = function(){
        var person = new Person();
        person.$setName({id:$scope.personId, name:$scope.person.name}, function () {
            person.$setSurname({id:$scope.personId, surname:$scope.person.surname}, function () {
                $location.path("/person");
            });
        });
    };

}]);