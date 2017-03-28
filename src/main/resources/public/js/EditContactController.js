(function() {

    var app = angular.module("personContacts");
    var EditContactController = function($scope, webservice, $routeParams, $location) {
		$scope.editContactSave = function() {
		    webservice.editContactWS($scope).then(onAddComplete, onError);

		};

		var onError = function(reason) {
			$scope.error = "Error fetching user";
		};
		var onAddComplete = function(reason) {
            $location.path("/person");

		};
		var onContactComplete = function(data) {
			$scope.contact = data;
		};
		$scope.contactId = $routeParams.id;
		webservice.getContact($scope.contactId).then(onContactComplete, onError);

	};

    app.controller("EditContactController", EditContactController);

}());