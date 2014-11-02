var app = angular.module("app", ['ngResource', 'ngRoute']);
//var app = angular.module("app");


app.factory('ToDos', ['$resource', function ($resource) {
    return $resource('resources/todos', {}, {
                         query: {
                             method: 'GET',
                             params: {},
                             isArray: false
                         },
                         save: {
                             method: 'POST'
                             //headers: {'Content-Type': 'application/json'},
                             //isArray: false
                         }
                     }
    )
}]);


app.controller("TodoController", ['$scope', 'ToDos', '$http', function ($scope, ToDos, $http) {
    $scope.data = ToDos.query();

    $scope.totalTodos = function () {
        if ($scope.data.todos !== undefined) {
            return $scope.data.todos.length;
        }
    };

    $scope.addTodo = function () {
        if ($scope.todoFormData !== "") {
            $scope.data.todos.push({'todo': $scope.todoFormData, 'done': false});
            $scope.todoFormData = "";
            //ToDos.save($scope.data);
        }
    };

    $scope.$watch('data', function () {
        console.log('changed');
        ToDos.save($scope.data);
    }, true);

}]);


