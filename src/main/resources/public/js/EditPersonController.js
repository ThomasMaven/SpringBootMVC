(function() {

    var app = angular.module("personContacts");
    var EditPersonController = function($scope, webservice, $routeParams, $location) {
		$scope.editPersonSave = function() {
		    webservice.setName($scope).then(onNameComplete, onError);
		};

		var onError = function(reason) {
			$scope.error = "Error updating person. Error status: " + reason.status + " " + status.text;
		};
		var onNameComplete = function(reason) {
            webservice.setSurname($scope).then(onUpdateComplete, onError);
		};
		var onUpdateComplete = function(reason) {
            $location.path("/person");
		};
		var onPersonComplete = function(data) {
			$scope.person = data;
		};
		$scope.personId = $routeParams.id;
		webservice.getPerson($scope.personId).then(onPersonComplete, onError);

	};

    app.controller("EditPersonController", EditPersonController);

}());