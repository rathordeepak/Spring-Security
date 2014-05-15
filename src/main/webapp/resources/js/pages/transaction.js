angular.module('app', [ 'appServices' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/income', {
				templateUrl : 'income.html',
				controller : IncomeCtrl
			}).when('/expense', {
				templateUrl : 'expense.html',
				controller : ExpenseCtrl
			}).otherwise({
				redirectTo : '/income'
			});
		} ]);

/* Controllers */

function IncomeCtrl($scope, Page, $http) {
	Page.setTitle("Income");
	$scope.editView = false;
	$scope.transition = {};
	var load = function() {
		$http.get(_contextPath + '/category-type').success(function(response) {
			$scope.categoryTypes = response.categoryTypes;
		});
	}

	
	$scope.onShowBasedType = function(categoryType) {
		$scope.categoryType = categoryType;
		$http.get(_contextPath + '/category-item/'+categoryType).success(function(response) {
			$scope.categoryItems = response.categoryItems;
		});
	}
	
	$scope.onCancel = function() {
		$scope.editView = false;
	}
	
	$scope.onEditView = function(index) {
		$scope.editView = true;
		$scope.category = $scope.categoryTypes[index];
	}
	
	$scope.onSave = function() {
		$scope.transition.categoryType = parseInt($scope.transition.categoryType); 
		$scope.transition.categoryItem = parseInt($scope.transition.categoryItem);
		$scope.transition.amount = parseFloat($scope.transition.amount);
		$scope.transition.id= 0;
		$http.post(_contextPath+'/transition',$scope.transition).success(function(response) {
			$scope.editView = false;
			load();
		});
	}
	
	$scope.onDelete = function(index) {
		$http.delete(_contextPath+'/transition/'+$scope.categoryTypes[index].id).
				success(function(response){
			load();
		});
	}
	
	load();

}

function ExpenseCtrl($scope, Page, $http) {
	Page.setTitle("Expense Items");
	$scope.categoryType = 1;
	$scope.editView = false;
	$scope.categoryItem = {};
	var load = function() {
		$http.get(_contextPath + '/category-item').success(function(response) {
			$scope.categoryTypes = response.categoryTypes;
		});
	}
	
	var showcategoryItems = function(categoryType) {
		$scope.categoryType = categoryType;
		$http.get(_contextPath + '/category-item/'+categoryType).success(function(response) {
			$scope.categoryItems = response.categoryItems;
		});
	}
	
	$scope.onShowBasedType = function(categoryType) {
		showcategoryItems(categoryType); 
	}
	
	$scope.onCancel = function() {
		$scope.editView = false;
	}

	$scope.onEditView = function(index) {
		$scope.editView = true;
		$scope.categoryItem = $scope.categoryItems[index] || {};
	}
	
	$scope.onSave = function() {
		$scope.categoryItem.type = parseInt($scope.categoryType);   
		if(!$scope.categoryItem.id) {
			$scope.categoryItem.id = 0;
		}
		$http.post(_contextPath+'/category-item',$scope.categoryItem).success(function(response) {
			$scope.editView = false;
			showcategoryItems($scope.categoryType);
		});
	}
	
	$scope.onDelete = function(index) {
		$http.delete(_contextPath+'/category-item/'+$scope.categoryItems[index].id).
				success(function(response){
			showcategoryItems($scope.categoryType);
		});
	}
	
	load();
	
}

/* Services */

angular.module('appServices', [])

.factory('Page', function($rootScope) {
	var pageTitle = "Untitled";
	return {
		title : function() {
			return pageTitle;
		},
		setTitle : function(newTitle) {
			pageTitle = newTitle;
		}
	};
});
