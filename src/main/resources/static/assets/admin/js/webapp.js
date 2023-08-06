var app = angular.module("myapp", ["ngRoute"]);

app.controller("dropdownController", function($scope, $window, $timeout) {
	$scope.form = {};
	$scope.logoff = function() {
		$window.location.href = 'http://localhost:8080/security/logoff';
	}
	$scope.containsRestrictedKeywords = function(password) {
    var restrictedKeywords = ["select", "union", "drop"];
    for (var i = 0; i < restrictedKeywords.length; i++) {
      if (password.toLowerCase().includes(restrictedKeywords[i])) {
        return true;
      }
    }
    return false;
  };
  $scope.hideErrorAfterDelay = function() {
	    $timeout(function() {
			$scope.submitted = false;	
			$scope.isDuplicateCampaignId = false;
	    },5000);
	};
});

app.config(function($routeProvider, $locationProvider) {

	$routeProvider
		.when("/", {
			templateUrl: "/assets/admin/layout/home.html"
		})
		.when("/campaign-management", {
			templateUrl: "/assets/admin/layout/campaign-management.html"
		})
		.when("/student-support", {
			templateUrl: "/assets/admin/layout/student-support.html"
		})
		.when("/account-management", {
			templateUrl: "/assets/admin/layout/account-management.html"
		})
		.when("/data-management", {
			templateUrl: "/assets/admin/layout/data-management.html"
		})
		.when("/authority-management", {
			templateUrl: "/assets/admin/layout/authority-management.html"
		})
		.when("/list-student", {
			templateUrl: "/assets/admin/layout/list-student.html"
		})
		.otherwise({
			redirectTo: "/"
		});

	$locationProvider.html5Mode(true);
});

app.run(function($rootScope, $location, $window, $http) {

	$rootScope.$on('$routeChangeStart', function() {
		$rootScope.loading = true;
	});
	$rootScope.$on('$routeChangeSuccess', function() {
		$rootScope.loading = false;
	});
	$rootScope.$on('$routeChangeError', function() {
		$rootScope.loading = false;
	});
	
	// Xử lý đăng nhập trước khi reload trang
	$rootScope.$on('$locationChangeStart', function(event) {
		
		//Goị yêu cầu kiểm tra đăng nhập
		$http.get(`/security/authenticated`).then(resp => {
			
			//Nếu chưa đăng nhập
			if(resp.data != true){
				//Điều hướng đến yêu cầu kiểm tra đăng nhập để tiến hành đăng nhập
				$window.location.href = '/security/authenticated';
			}
			
			//Nếu đã đăng nhập thì trang sẽ tiếp tục chạy bình thường
			
		}).catch(errors => {
			//Xuất lỗi nếu có trong quá trình
			console.log("Error", errors);
		});
	});
});

