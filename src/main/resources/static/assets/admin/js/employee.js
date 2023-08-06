let pathEmployee = "http://localhost:8080/rest";
app.controller("ctrl-employee", function($scope, $http) {
	$scope.form = {};
	$scope.items = [];

	$scope.create = function() {
		var item = angular.copy($scope.form);
		var url = `${pathEmployee}/employee`;
		$http.post(url, item).then(resp => {
			$scope.items.push(item);
			$scope.reset();
			console.log("Insert Successfully!", resp);
			alert("Thêm mới thành công!");
		}).catch(error => {
			console.log("Adding new encountered an error. Please check again.", error);
			$scope.reset();
			alert("Email đã được sử dụng");

		});
	}
	
	
	$scope.reset = function() {
		$scope.form = {};
		}
		
	$scope.reset();

});