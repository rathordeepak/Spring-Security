function registerCtrl($scope, $http) {
	$scope.save = function() {
		$http({
			method : 'POST',
			url : 'register.html',
			data : $scope.registerData,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(result) {
			console.log(result);
		});

	}
}