angular.module('app', [ 'appServices' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/account', {
				templateUrl : 'account.html',
				controller : AccountCtrl
			}).when('/transitionType', {
				templateUrl : 'transitionType.html',
				controller : TransitionTypeCtrl
			}).when('/transitionItem', {
				templateUrl : 'transitionItem.html',
				controller : TransitionItemCtrl
			}).otherwise({
				redirectTo : '/account'
			});
		} ]);

/* Controllers */

function MainCtrl($scope, Page, $http) {
	$scope.page = Page;
}

function AccountCtrl($scope, Page, $http) {
	Page.setTitle("account");
}

function TransitionTypeCtrl($scope, Page, $http) {
	Page.setTitle("Transition Types");
	$scope.editView = false;
	$scope.category = {};
	var load = function() {
		$http.get(_contextPath + '/category-type').success(function(response) {
			$scope.categoryTypes = response.categoryTypes;
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
		$http.post(_contextPath+'/category-type',$scope.category).success(function(response) {
			$scope.editView = false;
			load();
		});
	}
	
	$scope.onDelete = function(index) {
		$http.delete(_contextPath+'/category-type/'+$scope.categoryTypes[index].id).
				success(function(response){
			load();
		});
	}
	
	load();

}

function TransitionItemCtrl($scope, Page, $http) {
	Page.setTitle("Transition Items");
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
