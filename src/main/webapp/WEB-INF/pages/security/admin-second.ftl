<html>
<head>
<title>Second Admin page</title>
</head>
<body>
<h1>Second Admin page with freemarker</h1>
<p>
<a href="${rc.getContextPath()}/j_spring_security_logout" />" >Logout</a> <br/>
<a href="${rc.getContextPath()}/index.html">Home page</a><br/>
<a href="${rc.getContextPath()}/test.html">Test Area</a><br/>
</p>
</body>
</html>