app.controller("authority-ctrl", function($scope, $http, $location){
	$scope.roles = [];
	$scope.admins = [];
	$scope.authorities = [];
	
	$scope.initialize = function(){
		
		// load all roles
		$http.get("/rest/roles").then(resp => {
			$scope.roles = resp.data;
		})
		
		// load staffs and directors (administrators) [tải các tài khoản có role là staffs và directors]
		$http.get("/rest/employees?admin=true").then(resp => {
			$scope.admins = resp.data;
		})
		
		// load authorites of staffs and directors [ tải các quyền được cấp của các admin]
		$http.get("/rest/authorities?admin=true").then(resp => {
			$scope.authorities = resp.data;
		}).catch(error => {
			$location.path("/unauthorized");
		})
	}
	
	$scope.authority_of = function(acc, role){
		if($scope.authorities){
			return $scope.authorities.find(ur => ur.employee.employeeId == acc.employeeId && ur.role.roleId == role.roleId);
		}
	}
	
	// xử lý event khi click vào checkbox
	$scope.authority_changed = function(acc, role){
		var authority = $scope.authority_of(acc, role);
		if(authority){ // đã cấp quyền => thu hồi quyền (xóa)
			$scope.revoke_authority(authority);
		}else{ // chưa được cấp quyền, cấp quyền thêm mới
			authority = {employee: acc, role: role}; // tạo ra 1 authority mới
			$scope.grant_authority(authority);      // cấp quyền cho authority này
		}
	}
	
	// Thêm mới authority
	$scope.grant_authority = function(authority){
		$http.post(`/rest/authorities`, authority).then(resp => {
			$scope.authorities.push(resp.data) // sau khi save vào csdl. Bổ sung data vào authorities để hiển lên view
			alert("Successfully granted usage rights."); // Cấp quyền sử dụng thành công
		}).catch(error => {
			alert("Failed to grant usage rights.");        // Cấp quyền sử dụng thất bại
			console.log("Error", error);
		})
	}
	
	// Xóa authority
	$scope.revoke_authority = function(authority){
		$http.delete(`/rest/authorities/${authority.authorityId}`).then(resp => {
			var index = $scope.authorities.findIndex(a => a.authorityId == authority.authorityId);
			$scope.authorities.splice(index, 1);
			alert("Successfully revoked usage rights."); //  Thu hồi quyền sử dụng thành công
		}).catch(error => {
			alert("Failed to revoke usage rights.");     // Thu hồi quyền sử dụng thất bại.
			console.log("Error", error);
		})
	}
	
	$scope.initialize();
})