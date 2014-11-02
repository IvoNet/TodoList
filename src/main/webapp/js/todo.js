var app = angular.module("app", ['ngResource']);


app.factory('todoService', ['$resource', function ($resource) {
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


app.controller("TodoController", ['$scope', 'todoService', '$filter', function ($scope, todoService, $filter) {
    $scope.data = todoService.query();

    $scope.totalTodos = function () {
        if ($scope.data.todos !== undefined) {
            return $scope.data.todos.length;
        }
    };

    $scope.addTodo = function () {
        if ($scope.todoFormData !== "") {
            $scope.data.todos.push({'todo': $scope.todoFormData, 'done': false});
            $scope.todoFormData = "";
        }
    };

    $scope.clearCompleted = function () {
        $scope.data.todos = $filter('filter')($scope.data.todos, {done : false})
    };

    $scope.$watch('data', function () {
        console.log('changed');
        todoService.save($scope.data);
    }, true);

}]);