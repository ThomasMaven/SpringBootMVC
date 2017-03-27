(function() {
	
	var webservice = function($http) {
		var getPersonList = function(user) {
			return $http.get("http://127.0.0.1:8888/api/v1/person")
				.then(function(response){
					return response.data;
				});

		};
		var getPerson = function(id) {
			return $http.get("http://127.0.0.1:8888/api/v1/person/"+id)
				.then(function(response){
					return response.data;
				});

		};
		var deleteContact = function(id) {
			return $http.delete("http://127.0.0.1:8888/api/v1/contact/"+id)
				.then(function(response){
					return response.data;
				});

		};
		var deletePerson = function(id) {
			return $http.delete("http://127.0.0.1:8888/api/v1/person/"+id)
				.then(function(response){
					return response.data;
				});

		};
		return {
			getPerson: getPerson,
			deleteContact: deleteContact,
			deletePerson: deletePerson,
			getPersonList: getPersonList
		};
	};
	
	var module = angular.module("githubViewer");
	module.factory("webservice", webservice);
}());