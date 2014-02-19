'use strict';

/* Controllers */

var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', function($scope) {
	$scope.materials = [ {
		'name' : 'Медь'
	}, {
		'name' : 'Железо'
	}, {
		'name' : 'Свинец'
	} ];
});

//
// phonecatApp.controller('PhoneListCtrl',
// function($scope, $http, $templateCache) {
// $scope.method = 'GET';
// $scope.url = 'TestS';
// sessionStorage.setItem("testKey","testValue");
// //$scope.fetch = function() {
// $scope.code = null;
// $scope.response = null;
//	 
// $http({method: $scope.method, url: $scope.url, cache: $templateCache}).
// success(function(data, status) {
// $scope.status = status;
// $scope.materials = data;
//	        
//	   
//	       
// }).
// error(function(data, status) {
// // $scope.data = data || "Request failed";
// //alert('erro');
// $scope.status = status;
// });
// //};
//	 
// $scope.updateModel = function(method, url) {
// $scope.method = method;
// $scope.url = url;
// };
// }
// );
