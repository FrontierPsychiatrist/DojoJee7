var BigRockApp = angular.module("BigRockApp", []);

var ws = new WebSocket("ws://localhost:8080/websocket");

function AppCtrl($scope) {
  $scope.send = function() {
    var obj = {
      name: $scope.name,
      number1: $scope.number1,
      number2: $scope.number2,
      expression: $scope.expression
    };
    ws.send(JSON.stringify(obj));
  },
  $scope.alertClass = "alert alert-info",
  $scope.alertText = "Status",
  $scope.start = function() {
    $.ajax('/StartServlet', {
      beforeSend: function() {
        $scope.alertText = "Starting...";
      },
      success: function() {
        $scope.alertText = "Batch job gestartet!";
        $scope.alertClass = "alert alert-success";
        $scope.$apply();
      }, error: function() {
        $scope.alertText = "Fehler!";
        $scope.alertClass = "alert alert-danger";
        $scope.$apply();
      }
    })
  }
}