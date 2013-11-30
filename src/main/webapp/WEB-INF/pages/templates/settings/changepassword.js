profileApp.controller('SettingsLayoutController', [ '$scope', '$stateParams',
		function($scope, $stateParams) {
			console.log('m reached inisde');
			$scope.user = {
				name : "Bob Loblaw",
				email : "bobloblaw@lawblog.com",
				password : 'semi-secret',
				quotes : "Lorem ipsum dolor sic amet"
			};
		} ])