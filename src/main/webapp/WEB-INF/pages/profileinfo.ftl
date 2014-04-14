<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />

<div class="row-fluid" ng-controller="MainCtrl" ng-app=app>
    <div class="span3" id="sidebar">
        <@macro.profilemenu />
    </div>
    
    <!--/span-->
    <div class="span9" id="content">
         <ng-view>Loading...</ng-view>
    </div>
    
    <h1>{{page.title()}}</h1>
<!-- Inline Templates (Partials) -->
    
<script type=text/ng-template id=home.html>
    <!-- Home -->
    <ul>
        <li><a href="#/list">Show Items</a></li>
        <li><a href="#/settings">Settings</a></li>
    </ul>
</script>

<script type=text/ng-template id=list.html>
    <!-- List -->
    <p>Choose an Item</p>
    <ul>
        <li ng-repeat="item in items"><a href="#/detail/{{item.id}}">{{item.title}}</a></li>
    </ul>
</script>

<script type=text/ng-template id=detail.html>
    <!-- Detail -->
    <h2>{{item.title}}</h2>
    <p>{{item.detail}}</p>
    <hr>
    <p>{{item.id}}</p>
</script>

<script type=text/ng-template id=settings.html>
    <!-- Settings -->
    <p>Settings go here ...</p>
</script>
    
</div>
           
<@macro.showFooter>
<script src="${rc.getContextPath()}/resources/js/pages/profileinfo.js"></script>
</@macro.showFooter>