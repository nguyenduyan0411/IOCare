let pathImportedListStudent = "http://localhost:8080/rest";
app.controller("ctrl-import-list-student", function($scope, $http) {
	$scope.form = {};
	$scope.items = [];
	$scope.students = [];
	
	/*--Function xử lý nhập tệp--*/
	$scope.import = function(files) {
		var reader = new FileReader();
		reader.onloadend = async () => {
			var workbook = new ExcelJS.Workbook();
			await workbook.xlsx.load(reader.result);
			const worksheet = workbook.getWorksheet('Sheet1');
			// Kiểm tra xem workbook có worksheet là tên 'Sheet1' hay không
			if(!worksheet){
				// Không tìm thấy worksheet
				alert('Không tìm thấy worksheet có tên "Sheet1". Vui lòng kiểm tra file Excel.');
				$scope.showStudents();
				return;
			}

			var firstRow = worksheet.getRow(1);
			var firstCell = firstRow.getCell(1).value;
			var secondCell = firstRow.getCell(2).value;
			var thirdCell = firstRow.getCell(3).value;
			var fourthCell = firstRow.getCell(4).value;
			var fifthCell = firstRow.getCell(5).value;
			var sixthCell = firstRow.getCell(6).value;
			var seventhCell = firstRow.getCell(7).value;
			var eighthCell = firstRow.getCell(8).value;
			var ninthCell = firstRow.getCell(9).value;
			var tenthCell = firstRow.getCell(10).value;
			if (firstCell === 'studentId' && secondCell === 'fullname' && thirdCell === 'block' && fourthCell === 'nearestCourse' && fifthCell === 'initialAdmissionCourse' && sixthCell === 'statusCode' && seventhCell === 'currentSemester' && eighthCell === 'fieldOfStudy' && ninthCell === 'major' && tenthCell === 'majorId') {
				worksheet.eachRow((row, index) => {
					if (index > 1) {
						var student = {
							studentId: row.getCell(1).value,
							fullname: row.getCell(2).value,
							block: row.getCell(3).value,
							nearestCourse: row.getCell(4).value,
							initialAdmissionCourse: row.getCell(5).value,
							statusCode: row.getCell(6).value,
							currentSemester: row.getCell(7).value,
							fieldOfStudy: row.getCell(8).value,
							major: row.getCell(9).value,
							majorId: row.getCell(10).value,
						};
						$scope.students.push(student);
					}
				});	
			}else{
				alert('File excel không phù hợp!');
				$scope.reset();
				return;
			}
    	};
    	reader.readAsArrayBuffer(files[0]);
	};
	
	$scope.create = function(){
		var item = angular.copy($scope.form);
		$scope.students.forEach(function(student){
			$http.post("/rest/list-student", student).then(resp => {
				$scope.reset();
				console.log("Thêm danh sách sinh viên thành công", resp.data);
			}).catch(error => {
				console.log("Thêm danh sách thất bại", error);
			});
		});

  	}
	
	$scope.showStudents = function() {
		$http.get(`/rest/list-student`).then(resp =>{
			$scope.items = resp.data;
			console.log($scope.items);
			console.log("Success", resp);
		}).catch(errors => {
			console.log("Error", errors);
		});
	};
	
	 $scope.visibleItems = 10;

	$scope.showMore = function() {
		$scope.visibleItems += 10; // Thay đổi số lượng hiển thị khi nhấp vào nút "Xem thêm"
	};
	
	$scope.showStudents();
});