(function() {

    var app = angular.module("personContacts");
    var AddPersonController = function($scope, webservice, $routeParams, $location) {
		$scope.addPersonSave = function() {
		    webservice.addPersonWS($scope).then(onAddComplete, onError);

		};

		var onError = function(reason) {
			$scope.error = "Error adding person. Error status: " + reason.status + " " + status.text;
		};
		var onAddComplete = function(reason) {
            $location.path("/person");

		};
		$scope.personId = $routeParams.personId;
	};

    app.controller("AddPersonController", AddPersonController);

}());