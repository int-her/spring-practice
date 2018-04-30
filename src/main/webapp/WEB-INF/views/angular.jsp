<%--
  Created by IntelliJ IDEA.
  User: heojeongsu
  Date: 2018. 4. 29.
  Time: PM 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<body>
    <div ng-app="app" ng-controller="MainCtrl as main">
        {{ main.text }}
        <div>
            <input type="number" id="number" ng-model="main.number">
        </div>
        <div>
            {{ main.number }}
            {{ main.num }}
        </div>
        <button ng-click="main.add()" class="btn btn-default">더하기!</button>
    </div>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script type="text/javascript">
    var app = angular.module('app', []);

    app.controller('MainCtrl', ['$scope', function($scope) {
        $scope = this;

        $scope.text = 'Hello, Angular!';
        $scope.num = 1;
        $scope.add = function() {
            $scope.num = $scope.num + 1;
        }
    }]);
</script>
