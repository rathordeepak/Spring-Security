<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
  <head>
	<title>Login page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/style.css">
  </head>
<body id="login">
	<div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Job Portal</a>
                    <div class="nav-collapse collapse pull-right">
                        <ul class="nav navbar-nav navbar-right">
				            <li class="dropdown">
				              <a data-toggle="dropdown" class="dropdown-toggle" href="#">Select Language <b class="caret"></b></a>
				              <ul role="menu" class="dropdown-menu">
				                <li><a href="?lang=en">English</a></li>
				                <li><a href="?lang=de">German</a></li>
				                <li><a href="?lang=en">French</a></li>
				                <li><a href="?lang=de">Hindi</a></li>
				              </ul>
				            </li>
				          </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
	<div class="container">
		<form class="form-signin" method="post" action="j_spring_security_check">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="input-block-level" placeholder="Email address" name="j_username">
        <input type="password" class="input-block-level" placeholder="Password" name="j_password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form>
	</div>
	
	<script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/bootstrap.min.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/angular.js"></script>
</body>
</html>