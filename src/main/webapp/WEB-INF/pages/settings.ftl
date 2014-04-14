<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="row-fluid">
    <div class="span3" id="sidebar">
        <@macro.settingsmenu />
    </div>
    
    <!--/span-->
    <div class="span9" id="content">
       Settings
    </div>
</div>
           
<@macro.showFooter/>