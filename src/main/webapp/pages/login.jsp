<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
<link href="/css/style.css" rel="stylesheet">
<style >
.login
{

text-align: center;
margin-top:80px;
padding:50px;

}

</style>
</head>
<body> 
<form class='login'>
<div >
<input class="text" type='text' name="username" placeholder="enter username"><br><br>

<input class="text" type='password'name="password" placeholder="enter password"><br><br>

<input type="submit" value="sign in" formaction='login' formmethod="post" class="btn">&nbsp;&nbsp;

<a class='link' href="showregister" >sign up</a>
</div>

</form>
${smg}
${error}
</body>
</html>

