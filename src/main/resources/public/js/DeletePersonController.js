(function() {

	var app = angular.module("githubViewer");

	var DeletePersonController = function($scope, webservice, $routeParams, $location) {
		var onDeleteComplete = function(data) {
			$scope.person = data;
			$location.path("/person");

		};
		var onError = function(reason) {
			$scope.error = "Error fetching user";
			$scope.user.name = "Not found";
			$scope.user.surname = "Not found";
		};
		$scope.id = $routeParams.id;
		webservice.deletePerson($scope.id).then(onDeleteComplete, onError);

	};
	app.controller("DeletePersonController",DeletePersonController);
}());