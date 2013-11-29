/* myApp module */
angular.module('profileApp', [ 'ui.state', 'accountSettings' ]).config(
		[
				'$stateProvider',
				'$routeProvider',
				'$urlRouterProvider',
				function($stateProvider, $routeProvider, $urlRouterProvider) {

					var home = {
						name : 'home',
						url : '/',
						templateUrl : _context + '/templates/home.html',
						controller : [
								'$scope',
								function($scope) {
									$scope.awesomeThings = [ 'AngularJS',
											'AngularJS-Ui-Router' ];
								} ]
					};

					$stateProvider.state(home);
				} ]).run(
		[ '$rootScope', '$state', '$stateParams',
				function($rootScope, $state, $stateParams) {
					$rootScope.$state = $state;
					$rootScope.$stateParams = $stateParams;
					$state.transitionTo('home');
				} ]);

/* accountSettings Module */
angular
		.module('accountSettings', [ 'ui.state' ])
		.config(
				[
						'$stateProvider',
						'$routeProvider',
						'$urlRouterProvider',
						function($stateProvider, $routeProvider,
								$urlRouterProvider) {

							var settings = {
								name : 'settings',
								url : '/settings',
								abstract : true,
								templateUrl : _context
										+ '/templates/settings/main.html',

								controller : 'SettingsLayoutController'
							};

							var userBase = {
								name : 'settings.user',
								parent : settings,
								abstract : true,
								url : '',
								templateUrl :  _context
								+ '/templates/settings/changepassword.html',
							};
							var userDetails = {
								name : 'settings.user.default',
								parent : userBase,
								url : '',
								views : {
									'pass' : {
										template : '<div><label>Password <button class="btn" ng-click="edit()">Edit</button></label>**********</div>',
										controller : 'EditUserDetailsController'
									},
									'hint@' : {
										template : "editing user details"
									},
									'menu@settings' : {
										template : "user details"
									}
								}
							};

							var userQuotes = {
								name : 'settings.quotes',
								parent : settings,
								url : '/quotes',
								views : {
									'' : {
										template : '<h3>{{user.name}}\'s Quotes</h3><hr>'
												+ '<div><label>Quotes</label><textarea type="text" ng-model="user.quotes"></textarea></div>'
												+ '<button class="btn" ng-click="done()">Save</button>'
									},
									'hint@' : {
										template : "editing user quotes"
									},
									'menu@settings' : {
										template : "quotes edit"
									}
								}
							};

							$stateProvider.state(settings).state(userBase)
									.state(userDetails)
									.state(userQuotes);
						} ]).controller('SettingsLayoutController',
				[ '$scope', '$stateParams', function($scope, $stateParams) {
					$scope.user = {
						name : "Bob Loblaw",
						email : "bobloblaw@lawblog.com",
						password : 'semi-secret',
						quotes : "Lorem ipsum dolor sic amet"
					};
				} ]);