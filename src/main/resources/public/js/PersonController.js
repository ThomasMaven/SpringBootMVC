(function() {

	var app = angular.module("githubViewer");

	var PersonController = function($scope, webservice, $routeParams) {
		var onPersonComplete = function(data) {
			$scope.person = data;
		};
		var onError = function(reason) {
			$scope.error = "Error fetching user";
			$scope.user.name = "Not found";
			$scope.user.surname = "Not found";
		};
		$scope.id = $routeParams.id;
		$scope.repoSortOrder = "+name";
		webservice.getPerson($scope.id).then(onPersonComplete, onError);

	};
	app.controller("PersonController",PersonController);
}());