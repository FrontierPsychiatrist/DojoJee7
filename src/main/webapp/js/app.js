var ws = new WebSocket("ws://localhost:8080/websocket");

function ChatCtrl($scope) {
  ws.onmessage = function(message) {
    $scope.answer = message.data;
    $scope.$apply();
  }
  $scope.send = function() {
    ws.send($scope.messageText);
  }
}