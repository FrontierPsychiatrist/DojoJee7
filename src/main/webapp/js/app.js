var ws = new WebSocket("ws://localhost:8080/websocket");

function ChatCtrl($scope) {
  $scope.answers = [];
  ws.onmessage = function (message) {

  };
  $scope.send = function() {
    ws.send(

    );
  }
}