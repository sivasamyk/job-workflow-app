var app = angular.module('JobsWorkflowApp', ['ui.grid']);


app.controller('JobsController', ['$scope', function ($scope) {
    var jobs = [
        {
            "cardNo": 1,
            "cardDate": "01-Jan-2017",
            "type": "IT Filing",
            "client": "Micro Lab",
            "assignedTo": "Sampath",
            "dueDate": "10-Jan-2017"
        },
        {
            "cardNo": 2,
            "cardDate": "01-Jan-2017",
            "type": "IT Filing",
            "client": "Hayagriva School",
            "assignedTo": "Sampath",
            "dueDate": "10-Jan-2017"
        },
        {
            "cardNo": 3,
            "cardDate": "01-Jan-2017",
            "type": "IT Filing",
            "client": "Sivasamy Kaliappan",
            "assignedTo": "Sampath",
            "dueDate": "10-Jan-2017"
        }
    ];

    $scope.gridOptions = {
        data: jobs,
        enableFiltering: true
    };
}]);