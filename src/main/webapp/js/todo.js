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
                             method: 'POST',
                             headers: {'Content-Type': 'application/json'},
                             isArray: false
                         }
                     }
    )
}]);


app.controller("TodoController", ['$scope', 'ToDos', '$http', function ($scope, ToDos, $http) {
    //$scope.url = 'http://localhost:8080/TodoList/resources/todos';
    $scope.data = ToDos.query();
    //restServices.get('http://localhost:8080/TodoList/resources/todos');

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

    $scope.$watchCollection('data.todos', function (newValue, oldValue) {
        if (newValue !== oldValue) {
            console.log("changed");
            //$http({
            //  method: 'POST',
            //  data: $scope.data,
            //  url:'resources/todos',
            //  headers: {'Content-Type':'application/json'}
            //});
            ToDos.save($scope.data);
        }
    });

}]);

