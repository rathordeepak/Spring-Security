angular.module('app', [ 'appServices' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/edit-profile', {
				templateUrl : 'edit-profile.html',
				controller : EditProfileCtrl
			}).when('/change-password', {
				templateUrl : 'change-password.html',
				controller : ChangePasswordCtrl
			}).otherwise({
				redirectTo : '/edit-profile'
			});
		} ]);

/* Controllers */

function MainCtrl($scope, Page) {
	console.log(Page);
	$scope.page = Page;
}

function EditProfileCtrl($scope, Page) {
	Page.setTitle("Profile");
	$scope.editView = function(show) {
		$scope.editview = show;
	};

}

function ChangePasswordCtrl($scope, Page) {
	Page.setTitle("Change Password");
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
