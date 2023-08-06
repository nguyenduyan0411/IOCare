var app = angular.module("signIn", []);
app.controller('loginCtrl', function($scope, $timeout) {
   $scope.hideErrorAfterDelay = function() {
		$timeout(function() {
			$scope.submitted = false;
		}, 5000);
	};
	
	$scope.isDisabled = true;
	$scope.statusPass = false;
	$scope.statusUser = false;
	$scope.user = {};

	$scope.checkPasswordChanges = function() {
	  if ($scope.myForm.password.$error.required) {
			$scope.statusPass = true;
			$timeout(function() {
				$scope.statusPass = false;
			}, 5000);
		}
	}
	
	$scope.checkUsernameChanges = function() {
	  if ($scope.myForm.username.$error.required) {
			$scope.statusUser = true;
			$timeout(function() {
				$scope.statusUser = false;
			}, 5000);
		}
	}
	
	$scope.checkForm = function(){
		if ($scope.myForm.password.$error.required || $scope.myForm.username.$error.required ){
			$scope.isDisabled = true;
		}else{
			$scope.isDisabled = false;
		}
	}
	
	$scope.resetForm = function(){
		$scope.isDisabled = true;
		$scope.statusPass = false;
		$scope.statusUser = false;
		$scope.user = {};
	}
	
	$scope.resetForm();

});