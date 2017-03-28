(function() {
	
	var webservice = function($http) {
	    var serverURL = "http://127.0.0.1:8888";
	    var apiPrefix = "/api/v1/";
	    var personPrefix = "person/";
	    var contactPrefix = "customer/";

	    var personURL = serverURL + apiPrefix + personPrefix;
	    var contactURL = serverURL + apiPrefix + contactPrefix;

		var getPersonList = function(user) {
			return $http.get(personURL)
				.then(function(response){
					return response.data;
				});

		};
		var getPerson = function(id) {
			return $http.get(personURL + id)
				.then(function(response){
					return response.data;
				});

		};
		var deleteContact = function(id) {
			return $http.delete(contactURL + id)
				.then(function(response){
					return response.data;
				});

		};
		var deletePerson = function(id) {
			return $http.delete(personURL + id)
				.then(function(response){
					return response.data;
				});

		};

		var addContactWS = function(scope) {
            var dataObj = {
                    type : scope.type,
                    value : scope.value
            };
			return $http.post(personURL + scope.personId + '/addContact', dataObj)
				.then(function(response){
					return response.data;
				});

		};

		var addPersonWS = function(scope) {
            var dataObj = {
                    name : scope.name,
                    surname : scope.surname
            };
			return $http.post(personURL, dataObj)
				.then(function(response){
					return response.data;
				});

		};

        var getContact = function(id) {
            return $http.get(contactURL + id)
                .then(function(response){
                    return response.data;
                });

        };

		var editContactWS = function(scope) {
            var dataObj = {
                    id : scope.contactId,
                    type : scope.contact.type,
                    value : scope.contact.value
            };
			return $http.put(contactURL + scope.contactId, dataObj)
				.then(function(response){
					return response.data;
				});

		};
        var setName = function(scope) {
            return $http.get(personURL + scope.personId+"/setName/" + scope.person.name)
                .then(function(response){
                    return response.data;
                });

        };
        var setSurname = function(scope) {
            return $http.get(personURL + scope.personId + "/setSurname/" + scope.person.surname)
                .then(function(response){
                    return response.data;
                });

        };

		return {
		    setName : setName,
		    setSurname : setSurname,
		    editContactWS : editContactWS,
		    getContact: getContact,
		    addContactWS: addContactWS,
		    addPersonWS: addPersonWS,
			getPerson: getPerson,
			deleteContact: deleteContact,
			deletePerson: deletePerson,
			getPersonList: getPersonList
		};
	};
	
	var module = angular.module("githubViewer");
	module.factory("webservice", webservice);
}());