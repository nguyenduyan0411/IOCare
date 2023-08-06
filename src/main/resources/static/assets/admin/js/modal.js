var app = angular.module('myApp', ['ui.bootstrap']);
app.controller('myController', function($scope, $uibModal) {
  $scope.openModal = function() {
    var modalInstance = $uibModal.open({
      templateUrl: 'myModalContent.html',
      controller: 'ModalInstanceController'
    });
  };
});

app.controller('ModalInstanceController', function($scope, $uibModalInstance) {
  $scope.closeModal = function() {
    $uibModalInstance.dismiss('cancel');
  };
});