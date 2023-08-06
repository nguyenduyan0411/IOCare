let pathImportedData = "http://localhost:8080/rest";
app.controller("ctrl-import", function($scope, $http) {
	$scope.form = {};
	$scope.items = [];
	/*--Mảng chứa list nhân sự--*/
	$scope.employees = [];
	/*--Mảng chứa list tên file thư mục--*/
	$scope.fileExcelNames = [];
	/*--Mảng chứa list học kỳ--*/
	$scope.semesters = [];
	/*--Mảng chứa list chiến dịch--*/
	$scope.campaigns = [];
	
	$scope.fileName = '';
	$scope.students = [];
	
	/*--Mảng chứa danh sách sinh viên từ file excel--*/
	$scope.tableData = [];
	
	$scope.tableDataAssigned = []; // Mảng chứa danh sách sinh viên đã phân công
	
	/*--Cập nhật tên nhân sự phụ trách cho thuộc tính của sinh viên--*/
	$scope.update = function(){
		var student = angular.copy($scope.form);
		var url = `/rest/student/` + $scope.form.employees.employeeId;
		$http.put(url, student).then(resp => {
			var index = $scope.items.findIndex(item => item.studentId == student.studentId);
			$scope.items[index] = resp.data;
			alert("Cập nhật student thành công")
		}).catch(error => {
			console.log("Update failed.", error);
			alert("Cập nhật student thất bại")
		});
	};

	/*--Hiển thị danh sách sinh viên dựa vào tên file excel--*/
	$scope.showStudents = function() {
		$http.get(`/rest/student/` + $scope.selectedFileName).then(resp =>{
			$scope.tableData = resp.data;
		});
	};
	
	$scope.showStudents2 = function() {
		$http.get(`/rest/student2`).then(resp =>{
			$scope.tableDataAssigned = resp.data;
		});
	};
	
	
	/*--Lấy tất cả nhân sự--*/
	$scope.load_employees = function(){
		$http.get("/rest/employees").then(resp =>{
			$scope.employees = resp.data;
		});
	};
	
	/*--Lấy tất cả học kỳ vào select box--*/
	$scope.load_semester = function(){
		$http.get("/rest/semester").then(resp => {
			$scope.semesters = resp.data;
		});
	};
	/*--Lấy tất cả chiến dịch vào select box--*/
	$scope.load_campaign = function(){
		$http.get("/rest/campaign").then(resp => {
			$scope.campaigns = resp.data;
		});
	};
	/*--Function xử lý nhập tệp--*/
	$scope.import = function(files) {
		var reader = new FileReader();
		reader.onloadend = async () => {
			if ($scope.form.campaign.campaignId === 'CSVH') {
				var workbook = new ExcelJS.Workbook();
				await workbook.xlsx.load(reader.result);
				const worksheet = workbook.getWorksheet('Sheet1');
				// Kiểm tra xem workbook có worksheet là tên 'Sheet1' hay không
				if(!worksheet){
					// Không tìm thấy worksheet
					alert('Không tìm thấy worksheet có tên "Sheet1". Vui lòng kiểm tra file Excel.');
					$scope.load_all();
					$scope.load_filename();
					$scope.load_semester();
					$scope.load_campaign();
					$scope.reset();
					return;
				}
				var firstRow = worksheet.getRow(1);
				var firstCell = firstRow.getCell(1).value;
				var secondCell = firstRow.getCell(2).value;
				if(firstCell === 'studentId' && secondCell === 'subjectId'){
					worksheet.eachRow((row, index) => {
						if (index > 1) {
							var student = {
								studentId: row.getCell(1).value,
								subjectId: row.getCell(2).value,
								imported: {
									importedFileName: '',
								}
							};
							$scope.students.push(student);
						}
					});	  
				}else{
					alert('File excel không phù hợp. Vui lòng chọn file vắng học!');
					$scope.load_all();
					$scope.load_filename();
					$scope.load_semester();
					$scope.load_campaign();
					$scope.reset();
					return;
				}
			}else if ($scope.form.campaign.campaignId === 'CSHP') {
				var workbook = new ExcelJS.Workbook();
				await workbook.xlsx.load(reader.result);
				const worksheet = workbook.getWorksheet('Sheet1');
				// Kiểm tra xem workbook có worksheet là tên 'Sheet1' hay không
				if(!worksheet){
					// Không tìm thấy worksheet
					alert('Không tìm thấy worksheet có tên "Sheet1". Vui lòng kiểm tra file Excel.');
					$scope.load_all();
					$scope.load_filename();
					$scope.load_semester();
					$scope.load_campaign();
					$scope.reset();
					return;
				}
				var firstRow = worksheet.getRow(1);
				var firstCell = firstRow.getCell(1).value;
				var secondCell = firstRow.getCell(2).value;
				if (firstCell === 'studentId' && secondCell === 'totalFee'){
					worksheet.eachRow((row, index) => {
						if (index > 1) {
							var student = {
								studentId: row.getCell(1).value,
								totalFee: row.getCell(2).value,
								imported: {
									importedFileName: '',
								}
							};
							$scope.students.push(student);
						}
					});
				}else{
					alert('File excel không phù hợp. Vui lòng chọn file học phí!');
					$scope.load_all();
					$scope.load_filename();
					$scope.load_semester();
					$scope.load_campaign();
					$scope.reset();
					return;
				}
			}else{
				alert('File excel không phù hợp!');
				$scope.load_all();
				$scope.load_filename();
				$scope.load_semester();
				$scope.load_campaign();
				$scope.reset();
				return;
			}

			

			// Lưu tên tệp vào mảng importedFileNames
			$scope.importedFileNames.push(files[0].name);

			// Cập nhật giá trị cho biến $scope.fileName
			$scope.$apply(function() {
				$scope.fileName = files[0].name; 
			});
    	};
    	reader.readAsArrayBuffer(files[0]);
	};
  
	// Lấy tên tệp từ mảng importedFileNames khi trang tải
	$scope.importedFileNames = localStorage.getItem('importedFileNames') ? JSON.parse(localStorage.getItem('importedFileNames')) : [];
	if ($scope.importedFileNames.length > 0) {
		fileName = $scope.importedFileNames[$scope.importedFileNames.length - 1];
	}
  
	/*--Thêm mới importedData--*/
	$scope.create = function(){
		var item = angular.copy($scope.form);
		item.importedFileName = $scope.fileName;
		var url = `${pathImportedData}/imported`;
		$http.post(url, item).then(resp => {
			$scope.load_all();
			$scope.load_filename();
			console.log("Import file thành công", resp);

			$scope.students.forEach(function(student){
				student.imported.importedFileName = $scope.fileName;
				$http.post("/rest/student", student).then(resp => {
					$scope.reset();
					console.log("Thêm danh sách sinh viên thành công", resp.data);
				}).catch(error => {
					console.log("Lỗi", error);
				});
			});
		}).catch(error => {
			console.log("Error", error);
		});
  	}
  
	/*--Lấy tất cả importedData--*/
	$scope.load_all = function(){
		var url = `${pathImportedData}/imported`;
		$http.get(url).then(resp => {
			$scope.items = resp.data;
			console.log("Success", resp)
		}).catch(errors => {
			console.log("Error", errors)
		});
	};
  
    /*--Lấy tất cả tên thư mục excel vào select box--*/
    $scope.load_filename = function(){
		$http.get("/rest/imported").then(resp => {
			$scope.fileExcelNames = resp.data;
		});	
	};
  
  
    
	/*--Reset form--*/
	$scope.reset = function() {
		$scope.form = {};
		$scope.students = [];
        var inputFile = document.getElementById('file-excel');
        inputFile.value = '';
	}
	$scope.load_all();
	$scope.load_filename();
	$scope.load_semester();
	$scope.load_campaign();
	$scope.load_employees();
  	$scope.showStudents2();
  
/*--Phân công form--*/	


// Function để phân công sinh viên từ bảng "Chưa phân công" sang bảng "Đã phân công"
$scope.assignStudents = function() {
  // Kiểm tra xem đã chọn mã nhân sự hay chưa
  if (!$scope.form.employees.employeeId) {
    // Hiển thị thông báo lỗi nếu chưa chọn mã nhân sự
    alert("Vui lòng chọn mã nhân sự trước khi phân công!");
    return;
  }

  // Lặp qua danh sách sinh viên trong mảng tableData
  for (var i = $scope.tableData.length - 1; i >= 0; i--) {
    var student = $scope.tableData[i];
    // Kiểm tra xem sinh viên có được chọn hay không
    if (student.selected) {
      // Thiết lập employeeId cho sinh viên đã phân công
      student.employee = JSON.parse($scope.form.employees.employeeId);
      var url = `/rest/student/` + student.studentId;
      $http.put(url, student).then(function(resp) {
        var index = $scope.tableData.findIndex(function(item) {
          return item.studentId == student.studentId;
        });
        console.log("Cập nhật student thành công", resp);
        $scope.showStudents();
        $scope.showStudents2();
        $scope.disableAssignButton = true;
      }).catch(function(error) {
        console.log("Cập nhật student thất bại", error);
        alert("Phân công thất bại!");
      });
    }
  }
  alert("Phân công thành công!");
  $scope.selectedStudents = []; // Xóa danh sách sinh viên đã chọn
  $scope.selectAll = false; // Đặt lại trạng thái chọn tất cả checkbox
};

// Cập nhật lại mã nhân sự = null
$scope.deleteStudent = function(student) {
  var xacNhan = confirm("Bạn có muốn xóa không?");
  if (xacNhan) {
	  var url = `/rest/student/` + student.studentId;
	  student.employee = null; // Cập nhật mã nhân sự thành null
	  $http.put(url, student).then(function(resp) {
	    var index = $scope.tableDataAssigned.findIndex(function(item) {
	      return item.studentId == student.studentId;
	    });
	    console.log("Xóa sinh viên thành công", resp);
	    $scope.showStudents();
        $scope.showStudents2();
	  }).catch(function(error) {
	    console.log("Xóa sinh viên thất bại", error);
	    alert("Xóa sinh viên thất bại!");
	    alert("Xóa thất bại !");
	  });
  }else{
	  // Người dùng chọn "Cancel", không thực hiện xóa
	console.log("Xóa bị hủy");
  }
};

// Function để kiểm tra xem có sinh viên nào được chọn hay không
$scope.hasSelectedStudents = function() {
  return $scope.tableData.some(function(student) {
    return student.selected;
  });
};
	// Thêm một mảng selectedStudents để lưu trạng thái chọn của sinh viên
$scope.selectedStudents = [];

$scope.selectAll = false; // Thêm biến $scope.allSelected
$scope.allSelected = false; // Khởi tạo giá trị ban đầu

// Hàm cập nhật trạng thái của các checkbox trong phần body dựa trên giá trị của $scope.selectAll
  $scope.toggleSelectAll = function() {
  $scope.selectAll = !$scope.selectAll;
  $scope.tableData.forEach(function(student) {
    student.selected = $scope.selectAll;
  });
    $scope.updateSelectedEmployees(); // Cập nhật trạng thái mã nhân sự khi chọn tất cả checkbox
  };
  
  
  $scope.checkSelectAll = function() {
  $scope.selectAll = $scope.tableData.every(function(student) {
    return student.selected;
  });
};

// Hàm cập nhật danh sách sinh viên được chọn
$scope.updateSelectedStudents = function(student) {
  if (!student.selected && $scope.selectAll) {
    $scope.selectAll = false;
  } else if (student.selected) {
    $scope.selectedStudents.push(student);
  } else {
    var index = $scope.selectedStudents.findIndex(function(selectedStudent) {
      return selectedStudent.studentId === student.studentId;
    });
    $scope.selectedStudents.splice(index, 1);
  }
  $scope.updateSelectedEmployees(); // Cập nhật trạng thái mã nhân sự khi chọn từng checkbox
    $scope.checkSelectAll(); // Gọi hàm để kiểm tra trạng thái chọn tất cả

};

// Hàm cập nhật mã nhân sự cho các sinh viên được chọn
$scope.updateSelectedEmployees = function() {
  var selectedStudentsCount = $scope.selectedStudents.length;
  $scope.allSelected = (selectedStudentsCount === $scope.tableData.length);
  var selectedEmployeeId = $scope.form.employees.employeeId;
  $scope.selectedStudents.forEach(function(student) {
    if (student.employee) {
      student.employee.employeeId = selectedEmployeeId;
    }
  });
};


$scope.selectedStudentsAssigned = [];
$scope.selectAllAssigned = false; // Khởi tạo giá trị ban đầu

// Hàm cập nhật danh sách sinh viên đã chọn (đã phân công)
$scope.updateSelectedStudentsAssigned = function(student) {
  if (!student.selectedAssigned && $scope.selectAllAssigned) {
    $scope.selectAllAssigned = false;
  } else if (student.selectedAssigned) {
    $scope.selectedStudentsAssigned.push(student);
  } else {
    var index = $scope.selectedStudentsAssigned.findIndex(function(selectedStudent) {
      return selectedStudent.studentId === student.studentId;
    });
    $scope.selectedStudentsAssigned.splice(index, 1);
  }
};

// Hàm xóa danh sách sinh viên đã chọn (đã phân công)
$scope.deleteSelectedStudents = function() {
  var confirmDelete = confirm("Bạn có chắc chắn muốn xóa danh sách sinh viên đã chọn?");
  if (confirmDelete) {
    $scope.selectedStudentsAssigned.forEach(function(student) {
      var url = `/rest/student/` + student.studentId;
      student.employee = null; // Cập nhật mã nhân sự thành null
      $http.put(url, student).then(function(resp) {
        var index = $scope.tableDataAssigned.findIndex(function(item) {
          return item.studentId == student.studentId;
        });
        console.log("Xóa danh sách sinh viên đã chọn thành công", resp);
        $scope.showStudents2();
      }).catch(function(error) {
        console.log("Xóa danh sách sinh viên đã chọn thất bại", error);
        alert("Xóa danh sách sinh viên đã chọn thất bại!");
      });
    });
    $scope.selectedStudentsAssigned = []; // Reset danh sách sinh viên đã chọn
    $scope.selectAllAssigned = false; // Đặt lại trạng thái chọn tất cả checkbox
  }
};

$scope.toggleSelectAllAssigned = function() {
  var allSelected = $scope.tableDataAssigned.every(function(student) {
    return student.selectedAssigned;
  });

  $scope.selectAllAssigned = !allSelected;

  $scope.tableDataAssigned.forEach(function(student) {
    student.selectedAssigned = !$scope.selectAllAssigned;
    $scope.updateSelectedStudentsAssigned(student); // Cập nhật danh sách sinh viên đã chọn
  });
};


	
});