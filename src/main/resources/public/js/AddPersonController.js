(function() {

    var app = angular.module("githubViewer");
    var AddPersonController = function($scope, webservice, $routeParams, $location) {
		$scope.addPersonSave = function() {
		    webservice.addPersonWS($scope).then(onAddComplete, onError);

		};

		var onError = function(reason) {
			$scope.error = "Error fetching user";
		};
		var onAddComplete = function(reason) {
            $location.path("/person");

		};
		$scope.personId = $routeParams.personId;
	};

    app.controller("AddPersonController", AddPersonController);

}());