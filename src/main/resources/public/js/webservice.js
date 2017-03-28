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

		var addContactWS = function(scope) {
            var dataObj = {
                    type : scope.type,
                    value : scope.value
            };
            console.log(scope);
			return $http.post('http://127.0.0.1:8888/api/v1/person/'+scope.personId+'/addContact', dataObj)
				.then(function(response){
				    console.log(response.data);
					return response.data;
				});

		};

		var addPersonWS = function(scope) {
            var dataObj = {
                    name : scope.name,
                    surname : scope.surname
            };
            console.log(scope);
			return $http.post('http://127.0.0.1:8888/api/v1/person', dataObj)
				.then(function(response){
					return response.data;
				});

		};

        var getContact = function(id) {
            return $http.get("http://127.0.0.1:8888/api/v1/contact/"+id)
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
			return $http.put('http://127.0.0.1:8888/api/v1/contact/'+scope.contactId, dataObj)
				.then(function(response){
					return response.data;
				});

		};
		return {
		    editContactWS : editContactWS ,
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