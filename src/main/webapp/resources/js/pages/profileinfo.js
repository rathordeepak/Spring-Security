angular.module('app', ['appServices'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.
                when('/home', {templateUrl: 'home.html',   controller: HomeCtrl}).
                when('/list', {templateUrl: 'list.html',   controller: ListCtrl}).
                when('/detail/:itemId', {templateUrl: 'detail.html',   controller: DetailCtrl}).
                when('/settings', {templateUrl: 'settings.html',   controller: SettingsCtrl}).
                otherwise({redirectTo: '/home'});
}]);


/* Controllers */

function MainCtrl($scope, Page) {
    console.log(Page);
    $scope.page= Page; 
}

function HomeCtrl($scope, Page) {
    Page.setTitle("Welcome");
}


function ListCtrl($scope, Page, Model) {
    Page.setTitle("Items");
    $scope.items = Model.notes();

}

function DetailCtrl($scope, Page, Model, $routeParams, $location) {
    Page.setTitle("Detail");
    var id = $scope.itemId = $routeParams.itemId;
    $scope.item = Model.get(id);
}

function SettingsCtrl($scope, Page) {
    Page.setTitle("Settings");
}

/* Services */

angular.module('appServices', [])

        .factory('Page', function($rootScope){
            var pageTitle = "Untitled";
            return {
                title:function(){
                    return pageTitle;
                },
                setTitle:function(newTitle){
                    pageTitle = newTitle;
                }
            }
        })

        .factory ('Model', function () {
            var data = [
                {id:0, title:'Doh', detail:"A dear. A female dear."},
                {id:1, title:'Re', detail:"A drop of golden sun."},
                {id:2, title:'Me', detail:"A name I call myself."},
                {id:3, title:'Fa', detail:"A long, long way to run."},
                {id:4, title:'So', detail:"A needle pulling thread."},
                {id:5, title:'La', detail:"A note to follow So."},
                {id:6, title:'Tee', detail:"A drink with jam and bread."}
            ];
            return {
                notes:function () {
                    return data;
                },
                get:function(id){
                  return data[id];
                },
                add:function (note) {
                    var currentIndex = data.length;
                    data.push({
                        id:currentIndex, title:note.title, detail:note.detail
                    });
                }
            }
});
