<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="row-fluid" ng-app=app>
    <div class="span3" id="sidebar">
        <@macro.transactionmenu />
    </div>
    
    <!--/span-->
    <div class="span9" id="content">
    	 <h1>{{page.title()}}</h1>
    
	    <!--/span-->
	    <div class="span9" id="content">
	         <ng-view>Loading...</ng-view>
	    </div>
   </div>
    <script type=text/ng-template id=income.html>
    Income
			<div class="row-fluid" ng-hide="editView">
				<div class="span6">
					<button class="btn btn-mini pull-right" ng-click="onEditView(-1)">Add</button>
					<table class="table">
						<thead>
							<tr>
								<td>Description</td>
								<td></td>
							</tr>
						</thead>
						<tr>
						</tr>
					</table>
				</div>
			</div>
			
			<form class="form-horizontal" ng-show="editView">
		    	<div class="control-group">
					<label class="control-label">CategoryType</label>
					<div class="controls">
						<select ng-model="transition.categoryType" ng-change="onShowBasedType(transition.categoryType)">
							<option ng-repeat="ct in categoryTypes" value="{{ct.id}}">{{ct.description}}</option>
						</select>
					</div>
				</div>
		    	<div class="control-group">
					<label class="control-label">CategoryItem</label>
					<div class="controls">
						<select ng-model="transition.categoryItem">
							<option ng-repeat="ci in categoryItems" value="{{ci.id}}">{{ci.description}}</option>
						</select>
					</div>
				</div>
		    	<div class="control-group">
					<label class="control-label">Transition Date</label>
					<div class="controls">
						<input type="text" ng-model="transition.transDate">
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">Amount</label>
					<div class="controls">
						<input type="text" ng-model="transition.amount">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button class="btn btn-primary" ng-click="onSave()">Save</button>
						<button class="btn" ng-click="onCancel()">Back</button>
					</div>
				</div>
		    </form>
	</script>
	
	
	<script type=text/ng-template id=expense.html>
	expense
			<div class="row-fluid" ng-hide="editView">
				<div class="span6">
					<button class="btn btn-mini pull-right" ng-click="onEditView(-1)">Add</button>
					<table class="table">
						<thead>
							<tr>
								<td>Description</td>
								<td></td>
							</tr>
						</thead>
						<tr ng-repeat="ct in incomeItems">
							<td>{{ct.description}}</td>
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
					<label class="control-label">CategoryType</label>
					<div class="controls">
						<input type="text" ng-model="categoryItem.description">
					</div>
				</div>
		    	<div class="control-group">
					<label class="control-label">CategoryItem</label>
					<div class="controls">
						<input type="text" ng-model="categoryItem.description">
					</div>
				</div>
		    	<div class="control-group">
					<label class="control-label">Transition Date</label>
					<div class="controls">
						<input type="text" ng-model="categoryItem.description">
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">Amount</label>
					<div class="controls">
						<input type="text" ng-model="categoryItem.description">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button class="btn btn-primary" ng-click="onSave()">Save</button>
						<button class="btn" ng-click="onCancel()">Back</button>
					</div>
				</div>
		    </form>
	</script>
   
   
   
</div>
    
   
    
    
           
<@macro.showFooter>
<script src="${rc.getContextPath()}/resources/js/pages/transaction.js"></script>
</@macro.showFooter>