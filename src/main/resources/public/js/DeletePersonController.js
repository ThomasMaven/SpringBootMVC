(function() {

	var app = angular.module("personContacts");

	var DeletePersonController = function($scope, webservice, $routeParams, $location) {
		var onDeleteComplete = function(data) {
			$scope.person = data;
			$location.path("/person");

		};
		var onError = function(reason) {
			$scope.error = "Error deleting person. Error status: " + reason.status + " " + status.text;

		};
		$scope.id = $routeParams.id;
		webservice.deletePerson($scope.id).then(onDeleteComplete, onError);

	};
	app.controller("DeletePersonController",DeletePersonController);
}());