var hotpansServices = angular.module("HotPans", ["ngRoute"]);
var mailAddress = "abc";

function hotpansRouteConfig($routeProvider){
	$routeProvider.
		when("/",{
			controller: StartController,
			templateUrl: "start.html"
		}).
		when("/bakery",{
			controller: BakeryController,
			templateUrl: "bakery.html"
		}).
		when("/customer",{
			controller: CustomerController,
			templateUrl: "customer.html"
		}).
		when("/registed",{
			controller: RegistedController,
			templateUrl: "registed.html"
		}).
		when("/allMailAddress",{
			controller: AllMailAddressController,
			templateUrl: "allMailAddress.html"
		}).
		otherwise({
			redirectTo: "/"
		});
}

hotpansServices.config(hotpansRouteConfig);

function StartController($scope) {

}

function BakeryController($scope) {

}

function CustomerController($scope) {

}

function RegistedController($scope) {
	$scope.mailAddress = mailAddress;
}

function AllMailAddressController($scope, $http) {
	//$http.get('http://localhost:8080/api/bakerys').
	$http.get('https://guarded-waters-9162.herokuapp.com/api/bakerys').
	success(function(data1, status, headers, config) {
		$scope.bakerys = data1;

	});

	//$http.get('http://localhost:8080/api/customers').
	$http.get('https://guarded-waters-9162.herokuapp.com/api/customers').
	success(function(data2, status, headers, config) {
		$scope.customers = data2;
	});

}

hotpansServices.controller("registMailAddressController", function ($scope, $http, $location){
	var bakery = {};
	var customer = {};

	$scope.registBakeryMailAddress = function(){
		bakery.mailAddress = $scope.bakery.mailAddress;
		bakery.name = "nothing";
		console.log(bakery.mailAddress);
		$http({
			method : 'POST',
			//url : 'http://localhost:8080/api/bakerys',
			url : 'https://guarded-waters-9162.herokuapp.com/api/bakerys',
			data : bakery
		}).success(function(data) {
			//成功
			console.log("★成功");
			mailAddress = bakery.mailAddress;
			//location.reload();
			$location.path("/registed");
		}).error(function(data) {
			//失敗
			console.log("★失敗");
			alert("Error!! Please try again later.");
		});
	}

	$scope.registCustomerMailAddress = function(){
		customer.mailAddress = $scope.customer.mailAddress;
		customer.name = "nothing";
		console.log(customer.mailAddress);
		$http({
			method : 'POST',
			//url : 'http://localhost:8080/api/customers',
			url : 'https://guarded-waters-9162.herokuapp.com/api/customers',
			data : customer
		}).success(function(data) {
			//成功
			console.log("★成功");
			mailAddress = customer.mailAddress;
			//location.reload();
			$location.path("/registed");
		}).error(function(data) {
			//失敗
			console.log("★失敗");
			alert("Error!! Please try again later.");
		});
	}
});

