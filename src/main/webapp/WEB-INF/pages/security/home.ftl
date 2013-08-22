<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Home page with freemarker</title>
</head>
<body>
<h1>Home page  with freemarker</h1>
<p>This is Home page. It's available for all users.<br/>
<a href="${rc.getContextPath()}/sec/moderation.html">Moderation page</a><br/>
<a href="${rc.getContextPath()}/admin/first.html">First Admin page</a><br/>
<a href="${rc.getContextPath()}/admin/second.html">Second Admin page</a><br/>
<a href="${rc.getContextPath()}/test.html">Test Area</a><br/>
</p>
</body>
</html>