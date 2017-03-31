app.factory('Contact', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
    return $resource(
    		'http://127.0.0.1:8888/api/v1/contact/:id',
    		{id: '@id'},
    		{
    			update: {method: 'PUT' }

    		}
    );
}]);