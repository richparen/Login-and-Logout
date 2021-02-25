<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login and Logout</title>
    <meta  charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body background="https://s1.1zoom.ru/big0/890/Joker_hero_Joker_2019_Joaquin_Phoenix_Clown_572451_1280x857.jpg">


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
        </ul>
    </div>
</nav>



<form action="login" method="post">
    <div style="padding: 8% 10%;">
        <label for="userName" style="color:white;"> Name: </label>
        <input style="width: 30%;" class="form-control me-2" type="text" id="userName"  name="userName">
        <label for="password" style="color:white;"> password: </label>
        <input style="width: 30%;" class="form-control me-2" type="password" id="password"  name="password"><br/>
        <input class="btn btn-success" name="submit" value="Submit" type="submit">
    </div>
</form>

</body>
</html>
