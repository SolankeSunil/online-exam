<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register page</title>
<link href="/css/style.css" rel="stylesheet">
<style>
.register
{
text-align: center;
padding: 50px;
margin: 50px;

}
</style>
</head>
<body>
<form>
  <div class='register'>
  <input type='text' placeholder='first name' class='text' name='fname'><br><br>
  
  <input type='text' placeholder='last name' class='text' name='lname'><br><br>
  
  <input type='text' placeholder='inter email id' class='text' name='email'><br><br>
  
   <input type='number' placeholder='mobile number' class='text' name='mobile'><br><br>
   
  <input type='password' placeholder='password' class='text' name='password'><br><br>
   
  <input type='password' placeholder='comfirme password' class='text' name='password1'><br><br>
  
  <input type='submit' value='register' class='btn' formmethod='post' formaction='register'>
  <input type='submit' value='get' class='btn' formmethod='get' formaction='get'>
  <input type='submit' value='put' class='btn' formmethod='put' formaction='put'>
  <input type='submit' value='delete' class='btn' formmethod='delete' formaction='delete'>
  
</div>
 ${smg}
</form>  
</body>
</html>
