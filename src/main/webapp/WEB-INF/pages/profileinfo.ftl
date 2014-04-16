<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />

<div class="row-fluid" ng-controller="MainCtrl" ng-app=app>
    <div class="span3" id="sidebar">
        <@macro.profilemenu />
    </div>
    <h1>{{page.title()}}</h1>
    
    <!--/span-->
    <div class="span9" id="content">
         <ng-view>Loading...</ng-view>
    </div>
    
    
<!-- Inline Templates (Partials) -->
    
<script type=text/ng-template id=edit-profile.html>
	<div ng-hide="editview">
		<div class="row-fluid">
			<div class="span1">Name</div>
			<div class="span3">Arunachalam
				<button class="btn btn-small pull-right" ng-click="editView(true)">Edit</button>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span1">DOB</div>
			<div class="span3">18 Mar 1986</div>
		</div>
		<div class="row-fluid">
			<div class="span1">Email</div>
			<div class="span3">arunachalam@greytip.com</div>
		</div>
		<div class="row-fluid">
			<div class="span1">Mobile</div>
			<div class="span3">8892345697</div>
		</div>
	</div>


     <form class="form-horizontal" ng-show="editview">
    	<div class="control-group">
			<label class="control-label">Name</label>
			<div class="controls">
				<input type="text" placeholder="Name">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">DOB</label>
			<div class="controls">
				<input type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Email</label>
			<div class="controls">
				<input type="email">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Mobile</label>
			<div class="controls">
				<input type="number">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Gender</label>
			<div class="controls">
				<select>
					<option value="">--Select--</option>
					<option value="M">Male</option>
					<option value="F">Female</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button class="btn btn-primary">Save</button>
				<button class="btn" ng-click="editView(false)">Reset</button>
			</div>
		</div>
    </form>
</script>

<script type=text/ng-template id=change-password.html>
    <form class="form-horizontal">
    	<div class="control-group">
			<label class="control-label" for="inputPassword">Old Password</label>
			<div class="controls">
				<input type="password" placeholder="Old Password">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">New Password</label>
			<div class="controls">
				<input type="password" placeholder="New Password">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">Confirm Password</label>
			<div class="controls">
				<input type="password" placeholder="Confirm Password">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button class="btn btn-primary">Save</button>
				<button class="btn">Reset</button>
			</div>
		</div>
    </form>
    
</script>
    
</div>
           
<@macro.showFooter>
<script src="${rc.getContextPath()}/resources/js/pages/profileinfo.js"></script>
</@macro.showFooter>