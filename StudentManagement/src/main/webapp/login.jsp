<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>StudentLogin</title>
    <style>@charset "UTF-8";
body{
	background-image:url("https://wallpaperbat.com/img/564785-boston-college-zoom-background.jpg");
	background-size:cover;
	background-repeat:no-repeat;
    display:grid;
}
.body{
	display:flex;
	justify-content:center;
	justify-content:space-evenly;
}

.login-container{
	display:absolute;
	background: rgba(225,225,225,0.2);
	backdrop-filter:blur(5px);
	border-radius: 8px;
	padding:8px;
	box-shadow:2px 4px 8px black;
	width:40vh;
	
}
.input-group{
	display:grid;
	margin:8px;

}
input{
	margin:8px;
	background-color:transparent;
	height:3vh;
	width:30vh;
	border:none;
	outline:none;
	border-bottom:1.5px solid black;
	transition:all 0.5s ease; 
}
input:hover{
    box-shadow: 0 4px 4px aqua;
    border-radius:6px;
}
.signin{
	background-color:greenyellow;
	font-weight:bold;
	border-radius:8px;
	height:6vh;
	width:12vh;
	box-shadow:2px 4px 8px #808080;
}
.signin:hover{
	box-shadow:none;
	border-radius:8px;
	background-color:#80ffff;
}
.signin:active{
	background-color:#00ffff;
}</style>
</head>
<body>
   <h2>Pace Institute of Technology and Sciences</h2>
   <div class="body">
    <div class="login-container">
       <form action="login" method="post">
        <b style="text-decoration:underline;">Student Details</b>
            <div class="input-group">
                <label for="username">UserName:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <a href="forgot.jsp">Forgot Password?</a>
            <input type="submit" class="signin" id="sigin" value="Login"></input> 
            <div class="status">
              <% String status = (String) request.getAttribute("status");
                   if ("failed".equals(status)) { %>
                      <span style="color:red;">Invalid UserName or password</span>
                <% } %>
                </div>
        </form>
    </div>
    
    
    <div class="login-container">
        <form action="login2" method="post">
        <b style="text-decoration:underline;">Faculty Details</b>
            <div class="input-group">
                <label for="FacultyID">UserName:</label>
                <input type="text" id="FacultyID" name="FacultyID" required>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <a href="forgot.jsp">Forgot Password?</a>
            <input type="submit" class="signin" id="sigin" value="Login"></input>
            <div class="status">
              <% String status2 = (String) request.getAttribute("status2");
                   if ("failed".equals(status2)) { %>
                      <span style="color:red;">Invalid UserName or password</span>
                <% } %>
                </div>
        </form>
    </div>
    </div>
</body>
</html>
