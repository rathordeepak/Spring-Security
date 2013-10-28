<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
  <head>
	<title>Login page</title>
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
              <a data-toggle="dropdown" class="dropdown-toggle" href="#">Select Language <b class="caret"></b></a>
              <ul role="menu" class="dropdown-menu">
                <li><a href="?lang=en">English</a></li>
                <li><a href="?lang=de">German</a></li>
                <li><a href="?lang=en">French</a></li>
                <li><a href="?lang=de">Hindi</a></li>
              </ul>
            </li>
          </ul>
	    </nav>
	  </div>
	</header>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="panel panel-primary">
					    <div class="panel-heading">
					      <h3 class="panel-title">Sign In</h3>
					    </div>
					    <div class="panel-body">
					      <form class="form-horizontal" role="form" method="post" action="j_spring_security_check">
							  <div class="form-group">
							    <label for="inputEmail1" class="col-lg-2 control-label"><@spring.message "label.firstname"/></label>
							    <div class="col-lg-10">
							      <input type="text" class="form-control" name="j_username" placeholder="Email Or User name">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
							    <div class="col-lg-10">
							      <input type="password" class="form-control" name="j_password" placeholder="Password">
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-lg-offset-2 col-lg-10">
							      <div class="checkbox">
							        <label>
							          <input type="checkbox"> Remember me
							        </label>
							      </div>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-lg-offset-2 col-lg-10">
							      <button type="submit" class="btn btn-primary">Sign in</button>
							    </div>
							  </div>
							</form>

					    </div>
					  </div>
					</div>
				<div class="col-md-3"></div>
			</div>
		</div>	
	</div>
	
	<script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/bootstrap.min.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/angular.js"></script>
</body>
</html>