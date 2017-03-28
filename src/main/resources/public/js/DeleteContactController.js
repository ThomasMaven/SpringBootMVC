(function() {

	var app = angular.module("personContacts");

	var DeleteContactController = function($scope, webservice, $routeParams, $location) {
		var onDeleteComplete = function(data) {
			$scope.person = data;
			$location.path("/person");

		};
		var onError = function(reason) {
			$scope.error = "Error deleting contact. Error status: " + reason.status + " " + status.text;

		};
		$scope.id = $routeParams.id;
		webservice.deleteContact($scope.id).then(onDeleteComplete, onError);

	};
	app.controller("DeleteContactController",DeleteContactController);
}());