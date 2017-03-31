app.factory('Person', ['$resource', function ($resource) {

    var serverURL = "http://127.0.0.1:8888";
    var apiPrefix = "/api/v1/";
    var personPrefix = "person";
    var personId = "/:id";
    var personURL = serverURL + apiPrefix + personPrefix + personId;
    return $resource(
    		personURL,
    		{id: '@id', name: '@id', surname: '@id' },
    		{
    			update: { method: 'PUT' },
    			addContact: { method: 'POST', url: personURL + '/addContact' },
    			setName: { method: 'GET', url: personURL + '/setName' + '/:name' },
    			setSurname: { method: 'GET', url: personURL + '/setSurname' + '/:surname' }
    		}
    );
}]);