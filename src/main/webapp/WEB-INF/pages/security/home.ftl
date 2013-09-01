<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Home page with freemarker</title>
</head>
<body>
<h1>Home page  with freemarker</h1>

<#if menus?exists>
	<#list menus as menu>
		<a href="${rc.getContextPath()}${menu.url}.html">${menu.title}</a><br/></p>
	</#list>
</#if>
<a href="${rc.getContextPath()}/j_spring_security_logout" />Logout</a> <br/>
<p>This is Home page. It's available for all users.<br/>
<a href="${rc.getContextPath()}/">Index</a><br/>
<a href="${rc.getContextPath()}/index.html">Index</a><br/>
<a href="${rc.getContextPath()}/manager/home.html">Manager page</a><br/>
<a href="${rc.getContextPath()}/employee/home.html">Employee page</a><br/>
<a href="${rc.getContextPath()}/admin/home.html">Admin page</a><br/>
</p>
</body>
</html>