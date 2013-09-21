var BigRockApp = angular.module("BigRockApp", []);

//var ws = new WebSocket("ws://localhost:8080/websocket");

function SendCtrl($scope) {
  $scope.send = function() {
    var obj = {
      name: $scope.name,
      number1: $scope.number1,
      number2: $scope.number2,
      expression: $scope.expression
    };
    console.log(JSON.stringify(obj));
    /*ws.send(

    );*/
  }
}

function RecvCtrl($scope) {
  /*ws.onmessage = function (message) {

  };*/
}