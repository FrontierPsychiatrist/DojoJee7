var ws = new WebSocket("ws://localhost:8080/websocket");

function ChatCtrl($scope) {
  $scope.answers = [];
  ws.onmessage = function (message) {
      console.log(message);
      $scope.answers.push(JSON.parse(message.data));
      $scope.$apply();
  };
  $scope.send = function() {
    ws.send(
        JSON.stringify({user:"me", message:$scope.messageText})
      );
  }
}