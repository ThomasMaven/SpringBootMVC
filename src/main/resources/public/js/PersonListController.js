(function() {

	var app = angular.module("githubViewer");

	var PersonListController = function($scope, webservice, $routeParams) {
		var onPersonComplete = function(data) {
			$scope.personList = data;
		};
		var onError = function(reason) {
			$scope.error = "Error fetching user";
			$scope.user.name = "Not found";
			$scope.user.surname = "Not found";
		};

		$scope.repoSortOrder = "+name";
		webservice.getPersonList().then(onPersonComplete, onError);

	};
	app.controller("PersonListController",PersonListController);
}());