<%--
  Created by IntelliJ IDEA.
  User: moritz
  Date: 9/20/13
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Hello JEE7</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/angular.min.js" type="text/javascript"><!-- --></script>
    <script src="js/app.js"><!-- --></script>
</head>
<body ng-app>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <h2>Menü</h2>
        </div>
        <div class="col-md-10">
            <h2>Main</h2>
            <div ng-controller="ChatCtrl">
                <form ng-submit="send()">
                    <div class="form-group">
                        <label>
                            <input class="form-control" type="text" ng-model="messageText" placeholder="Nachricht"/>
                            <button class="btn btn-primary" type="submit">Senden</button>
                        </label>
                    </div>
                </form>
                <span>{{answer}}</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>