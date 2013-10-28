<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
  <head>
	<title>Home page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/style.css">
  </head>
<body>
	<header role="banner" class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
	  <div class="container">
	    <div class="navbar-header">
	      <button data-target=".bs-navbar-collapse" data-toggle="collapse" type="button" class="navbar-toggle">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="../">Team work</a>
	    </div>
	    <nav role="navigation" class="collapse navbar-collapse bs-navbar-collapse">
	      <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a data-toggle="dropdown" class="dropdown-toggle" href="#">arunachalam<b class="caret"></b></a>
              <ul role="menu" class="dropdown-menu">
                <li><a href="?lang=en">Account Settings</a></li>
                <li><a href="${rc.getContextPath()}/j_spring_security_logout">Logout</a></li>
              </ul>
            </li>
          </ul>
	    </nav>
	  </div>
	</header>
	<div class="container">
		<div class="row-fluid">
			<div class="span3">xxx</div>
			<div class="span9">xxxx</div>
		</div>	
	</div>
	
	<script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/bootstrap.min.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/angular.js"></script>
</body>
</html>
