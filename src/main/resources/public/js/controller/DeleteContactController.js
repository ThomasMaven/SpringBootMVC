'use strict';

app.controller('DeleteContactController', ['$scope', 'Contact', '$location', '$routeParams', function($scope, Contact, $location, $routeParams) {

    $scope.contactId = $routeParams.id;
    Contact.delete({id:$scope.contactId}, function () {
        $location.path("/person");
    });


}]);