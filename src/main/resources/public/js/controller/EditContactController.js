'use strict';

app.controller('EditContactController', ['$scope', 'Contact', '$location', '$routeParams', function($scope, Contact, $location, $routeParams) {

    $scope.contactId = $routeParams.id;
    var fetchContact = function(){
      $scope.contact = Contact.get({id:$scope.contactId});
    };
    fetchContact();

    $scope.updateContact = function(){
        var contact = new Contact({
              id: $scope.contactId,
              value : $scope.contact.value,
              type : $scope.contact.type
        })
        contact.$update({id:$scope.contactId}, function () {
            $location.path("/person");
        });
    };

}]);