(function() {

    var app = angular.module("personContacts");
    var AddContactController = function($scope, webservice, $routeParams, $location) {
		$scope.addContactSave = function() {
		    webservice.addContactWS($scope).then(onAddComplete, onError);

		};

		var onError = function(reason) {
			$scope.error = "Error adding contact. Error status: " + reason.status + " " + status.text;
		};
		var onAddComplete = function(reason) {
            $location.path("/person");

		};
		$scope.personId = $routeParams.personId;
	};

    app.controller("AddContactController", AddContactController);

}());