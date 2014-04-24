<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />

<div class="row-fluid" ng-controller="MainCtrl" ng-app=app>
    <div class="span3" id="sidebar">
        <@macro.settingsmenu />
    </div>
    <h1>{{page.title()}}</h1>
    
    <!--/span-->
    <div class="span9" id="content">
         <ng-view>Loading...</ng-view>
    </div>
    
    
<!-- Inline Templates (Partials) -->
    
<script type=text/ng-template id=account.html>
	Account View
</script>

<script type=text/ng-template id=transitionType.html>
	<div class="row-fluid" ng-hide="editView">
		<div class="span6">
			<button class="btn btn-mini pull-right" ng-click="onEditView(-1)">Add</button>
			<table class="table">
				<thead>
					<tr>
						<td>Description</td>
						<td>Code</td>
						<td></td>
					</tr>
				</thead>
				<tr ng-repeat="ct in categoryTypes">
					<td>{{ct.description}}</td>
					<td>{{ct.code}}</td>
					<td>
						<button class="btn btn-mini" ng-click="onEditView($index)">Edit</button>
						<button class="btn btn-mini" ng-click="onDelete($index)">Delete</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<form class="form-horizontal" ng-show="editView">
    	<div class="control-group">
			<label class="control-label">Description</label>
			<div class="controls">
				<input type="text" ng-model="category.description">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Code</label>
			<div class="controls">
				<input type="text" ng-model="category.code">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button class="btn btn-primary" ng-click="onSave()">Save</button>
				<button class="btn">Reset</button>
			</div>
		</div>
    </form>
    
</script>

<script type=text/ng-template id=transitionItem.html>
	<div class="row-fluid" ng-hide="editView">
		<div class="span6">
			<button class="btn btn-mini pull-right" ng-click="onEditView(-1)">Add</button>
			<select ng-model="categoryType">
				
			</select> 
			
			
			<table class="table">
				<thead>
					<tr>
						<td>Description</td>
						<td>Code</td>
						<td></td>
					</tr>
				</thead>
				<tr ng-repeat="ct in categoryItem">
					<td>{{ct.description}}</td>
					<td>{{ct.code}}</td>
					<td>
						<button class="btn btn-mini" ng-click="onEditView($index)">Edit</button>
						<button class="btn btn-mini" ng-click="onDelete($index)">Delete</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</script>
    
</div>
           
<@macro.showFooter>
<script src="${rc.getContextPath()}/resources/js/pages/settings.js"></script>
</@macro.showFooter>