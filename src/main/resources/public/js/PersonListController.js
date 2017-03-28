(function() {

	var app = angular.module("personContacts");

	var PersonListController = function($scope, webservice, $routeParams) {
		var onPersonComplete = function(data) {
			$scope.personList = data;
		};
		var onError = function(reason) {
			$scope.error = "Error fetching person list. Error status: " + reason.status + " " + status.text;
		};

		$scope.repoSortOrder = "+name";
		webservice.getPersonList().then(onPersonComplete, onError);

	};
	app.controller("PersonListController",PersonListController);
}());