(function() {

	var app = angular.module("personContacts");

	var PersonController = function($scope, webservice, $routeParams) {
		var onPersonComplete = function(data) {
			$scope.person = data;
		};
		var onError = function(reason) {
			$scope.error = "Error fetching person. Error status: " + reason.status + " " + status.text;
		};
		$scope.id = $routeParams.id;
		$scope.repoSortOrder = "+name";
		webservice.getPerson($scope.id).then(onPersonComplete, onError);

	};
	app.controller("PersonController",PersonController);
}());