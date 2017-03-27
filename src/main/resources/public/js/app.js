(function() {
	
	var app = angular.module("githubViewer", ["ngRoute"]);
	
	app.config(function($routeProvider){
		$routeProvider
		.when("/person/:id",{
			templateUrl: "views/person.html",
			controller: "PersonController"
		})
		.when("/person",{
			templateUrl: "views/personlist.html",
			controller: "PersonListController"
		}).otherwise({redirectTo:"/person"})
	});

}());