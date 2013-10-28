<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html ng-app>
  <head>
	<title>Register page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/style.css">
  </head>
<body ng-controller="registerCtrl">
	<header role="banner" class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
	  <div class="container">
	    <div class="navbar-header">
	    </div>
	  </div>
	</header>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="panel panel-primary">
					    <div class="panel-heading">
					      <h3 class="panel-title">Register</h3>
					    </div>
					    <div class="panel-body">
					    	<form class="form-horizontal" name="registerForm">
					    		<div class="control-group">
						    		<label class="control-label">Name</label>
						    		<div class="controls">
						    			<input type="text" name="name" ng-model="registerData.name" />
						    		</div>
					    		</div>
					    		<div class="control-group">
						    		<label class="control-label">Password</label>
						    		<div class="controls">
						    			<input type="text" name="password" ng-model="registerData.password" />
						    		</div>
					    		</div>
					    		<div class="control-group">
						    		<label class="control-label">Contact No</label>
						    		<div class="controls">
						    			<input type="text" name="contactno" ng-model="registerData.contactno">
						    		</div>
					    		</div>
					    	</form>
							<div class="control-group">
					    		<div class="controls">
					    			<button class="btn btn-warning" ng-click="cancel()">Cancel</button>
					    			<button class="btn btn-primary" ng-click="save()">save</button>
					    		</div>
				    		</div>
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
	<script src="${rc.getContextPath()}/resources/js/pages/register.js"></script>
</body>
</html>