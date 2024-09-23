<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form</title>
<style>
@charset "UTF-8";body{
	background-image:url("https://th.bing.com/th/id/OIP.f-h93_w8z43JNtb1-_mfbgHaDt?rs=1&pid=ImgDetMain");
	background-size:cover;
	background-repeat:no-repeat;
	
	
}
.login-container{
	display: flex;
	justify-content:center;
	align-items:center;
}
form{
	display:absolute;
	border-radius: 8px;
	border:1px solid white;
	background:rgba(225,225,225,0.2);
	backdrop-filter:blur(5px);
	padding:8px;
	box-shadow:2px 4px 8px black;
	width:60vh;
	
}
input{
	margin:8px;
	height:4vh;
	width:40vh;
	border:1.5px solid aqua;
	border-radius:4px;
	outline:none;
	background-color:transparent;
	transition: all 0.25s ease;
}
input:hover{
    box-shadow: 0 0 4px 4px aqua;
    border-radius:4px;
}
button{
	background-color:#00ffff;
	font-weight:bold;
	border-radius:8px;
	height:7vh;
	width:20vh;
	box-shadow:2px 4px 8px #808080;
	margin:10px;
	transition: all 0.25s ease;
}
button:hover{
	border-radius:8px;
	background-color:#80ffff;
}
button:active{
	background-color:#004040;
}
</style>
</head>
<body>
<h2> Register Student</h2>
<div class="login-container">

	<form action="register" method="post">
	<h3>Enter Student Details</h3>
    <input type="text" name="id" placeholder="Enter RollNo" required>
    <input type="text" name="name" placeholder="Enter Name" required spellcheck="true">
    <input type="email" name="email" placeholder="Enter Email" required>
    <input type="text" name="contact" placeholder="Enter Contact" required>
    <input type="text" name="branch" placeholder="Enter Branch" required>
    <input type="text" name="group" placeholder="Enter Section" required>
    <input type="text" name="year" placeholder="Enter Year" required>
    <input type="password" name="pass" placeholder="Create NewPassword" required>
    <button type="submit" class="login-container">Register</button>
    <div class="status">
            
                <% String status = (String) request.getAttribute("status");
                   if ("failed".equals(status)) { %>
                      <p style="color:red;">Invalid details</p>
                <% } %>
            </div>
</form>
</div>
<a href="index2.jsp" style="color:white;border:1px solid white;border-radius:3px;text-decoration:none;">Home</a>
</body>

</html>