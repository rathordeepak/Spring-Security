<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="row-fluid">
    <div class="span3" id="sidebar">
        <@macro.transactionmenu />
    </div>
    
    <!--/span-->
    <div class="span9" id="content">
       transaction
    </div>
</div>
           
<@macro.showFooter/>