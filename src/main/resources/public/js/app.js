(function() {
	
	var app = angular.module("personContacts", ["ngRoute"]);
	
	app.config(function($routeProvider){
		$routeProvider
		.when("/person/:id",{
			templateUrl: "views/person.html",
			controller: "PersonController"
		})
		.when("/person/:id/edit",{
			templateUrl: "views/edit_person.html",
			controller: "EditPersonController"
		})
		.when("/person/:id/delete",{
			templateUrl: "views/person.html",
			controller: "DeletePersonController"
		})
		.when("/person",{
			templateUrl: "views/personlist.html",
			controller: "PersonListController"
		})
		.when("/person/:personId/add",{
			templateUrl: "views/add_contact.html",
			controller: "AddContactController"
		})
        .when("/person/add/person",{
            templateUrl: "views/add_person.html",
            controller: "AddPersonController"
        })
		.when("/contact/:id/edit",{
			templateUrl: "views/edit_contact.html",
			controller: "EditContactController"
		})
		.when("/contact/:id/delete",{
			templateUrl: "views/person.html",
			controller: "DeleteContactController"
		})
		.otherwise({redirectTo:"/person"})
	});

}());