<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login page</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h1>Login page with freemarker</h1>

<form method="post" action="j_spring_security_check">
<table>
<tbody>
<tr>
<td>Login:</td>
<td><input type="text" name="j_username" id="j_username"size="30" maxlength="40"  /></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login" /></td>
</tr>
</tbody>
</table>
</form>	

<p>
<a href="${rc.getContextPath()}/index.html">Home page</a><br/>
</p>
</body>
</html>