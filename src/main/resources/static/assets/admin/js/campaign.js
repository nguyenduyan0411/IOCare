let pathCampaign = "http://localhost:8080/rest";
app.controller("ctrl-campaign", function($scope, $http, $filter, $timeout){
	$scope.form = {};
	$scope.items = [];
	
	/*--Xóa chiến dịch--*/
	$scope.delete2 = function(campaignId) {
	  // Hiển thị hộp thoại xác nhận
	  var xacNhan = confirm("Bạn có muốn xóa không?");
	  
	  // Kiểm tra câu trả lời của người dùng
	  if (xacNhan) {
	    var url = `${pathCampaign}/campaign/${campaignId}`;
	    $http.delete(url).then(resp => {
	      // Tìm ra phần tử tại vị trí sẽ xóa.
	      var index = $scope.items.findIndex(item => item.campaignId == campaignId);
	      $scope.items.splice(index, 1); // Xóa 1 phần tử tại vị trí đó
	      $scope.reset2();
	      console.log("Success", resp);
	    }).catch(error => {
	      console.log("Error", error);
	    });
	  } else {
	    // Người dùng chọn "Cancel", không thực hiện xóa
	    console.log("Xóa bị hủy");
	  }
	}

	
	$scope.isDisabled = true;
	$scope.isIdDisabled = false;
	
	/*--Hiển thị chiến dịch lên form--*/
	$scope.edit2 = function(campaignId){
		var url = `${pathCampaign}/campaign/${campaignId}`;
		
		$http.get(url).then(resp => {
			$scope.isDisabled = false;
			$scope.isIdDisabled = true;
			$scope.form = resp.data;
			console.log("Success", resp);
		}).catch(errors => {
			console.log("Error", errors);
		});
	}
	
	/*--Hiển thị tất cả chiến dịch--*/
	$scope.findAll2 = function(){
		var url = `${pathCampaign}/campaign`;
		$http.get(url).then(resp => {
			$scope.items = resp.data;
			console.log("Success", resp)
		}).catch(errors => {
			console.log("Error", errors)
		});
	}
	
	$scope.isDuplicateCampaignId = false;
	$scope.showMaxLengthError = false;
	$scope.isLowercaseError = false;

	$scope.checkDuplicateCampaignId = function(campaignId) {
	  $scope.isDuplicateCampaignId = $scope.items.some(function(item) {
	    return item.campaignId === campaignId;
	  });
	};
	// Tắt eerror sau 5 giây
	$scope.hideErrorAfterDelay = function() {
	    $timeout(function() {
			$scope.submitted = false;	
			$scope.isDuplicateCampaignId = false;
	    },5000);
	};

	/*--Gọi API Backend tạo mới học kỳ--*/
	$scope.create2 = function() {
	  var isFormValid = $scope.myForm.$valid;
	  var isDataFilled = $scope.form.campaignId && $scope.form.campaignName;
	
	  if (isFormValid && isDataFilled) {
	    var item = angular.copy($scope.form);
	    
	    // Kiểm tra trùng mã chiến dịch
	    $scope.checkDuplicateCampaignId(item.campaignId);
	    if ($scope.isDuplicateCampaignId) {
	      console.log("Mã chiến dịch đã tồn tại!");
	      $scope.hideErrorAfterDelay(); // Hide error message after 5 seconds
	      return;
	    }
	    
	    if (/[a-z]/.test(item.campaignId)) {
		  $scope.isLowercaseError = true; // Hiển thị thông báo lỗi mã chiến dịch viết thường
		
		  setTimeout(function() {
		    $scope.isLowercaseError = false; // Ẩn thông báo lỗi sau 5 giây
		    $scope.$apply(); // Áp dụng các thay đổi vào $scope (nếu cần)
		  }, 5000); // 5 giây (5000 milliseconds)
		
		  return;
		}
	    
	    if ($scope.form.campaignId.length > 5) {
	        $scope.isIdDisabled = false; // Cho phép chỉnh sửa mã chiến dịch
	        $scope.showMaxLengthError = false;
	        $scope.isDuplicateCampaignId = false; // Ẩn thông báo mã chiến dịch đã tồn tại (nếu có)
	        $scope.myForm.campaignId.$setValidity('length', false); // Đánh dấu lỗi độ dài mã chiến dịch
	        $scope.hideErrorAfterDelay(); // Hide error message after 5 seconds
	        return; // Dừng quá trình tạo chiến dịch nếu có lỗi
	    }
	    
	    var url = `${pathCampaign}/campaign`;
	
	    $http.post(url, item).then(resp => {
	      $scope.items.push(item);
	      $scope.reset2();
	      console.log("Insert value to Campaign Successfully!", resp);
		  alert("Tạo chiến dịch thành công!");
	      $scope.submitted = false; // Reset submitted flag
	    }).catch(error => {
	      console.log("Adding new encountered an error. Please check again.", error);
	    });
	  } else {
	    $scope.submitted = true;
	    $scope.hideErrorAfterDelay(); // Hide error message after 5 seconds

	  }
	}	

	$scope.formChanges = false;

	$scope.checkFormChanges = function() {
	  $scope.formChanges = true;
	}
	
	/*--update*/
	$scope.update2 = function() {
	if (!$scope.formChanges) {
    // Không có sự thay đổi, không thực hiện cập nhật
   		return;
  	}
    var item = angular.copy($scope.form);
    $http
        .put(`${pathCampaign}/campaign/${item.campaignId}`, item)
        .then((resp) => {
            var index = $scope.items.findIndex((p) => p.campaignId == item.campaignId);
            $scope.items[index] = resp.data;
            $scope.reset2();
            console.log("Cập nhật chiến dịch thành công!", resp);
            alert("Cập nhật chiến dịch thành công!");
        })
        .catch((error) => {
			$scope.reset2();
            console.log("Lỗi khi cập nhật chiến dịch!", error);
            alert("Lỗi khi cập nhật chiến dịch!");
        });
	};


	/*--Reset form--*/
	$scope.reset2 = function(){
		$scope.form = {};
		$scope.isDisabled = true;
		$scope.isIdDisabled = false;
		$scope.formChanges = false;
		$scope.submitted = false;
		$scope.isDuplicateCampaignId = false;
		$scope.isLowercaseError = false;
		if (!$scope.myForm.$pristine) {
	        $scope.myForm.campaignId.$setValidity('length', true); // Đặt lại trạng thái hợp lệ cho trường campaignId
	    }
	}
	
	
	/*--Gọi hàm reset--*/
	$scope.reset2();
	
	/*--Gọi hàm hiển thị tất cả học kỳ--*/
	$scope.findAll2();
});