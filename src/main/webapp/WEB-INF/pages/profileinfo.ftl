<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
		<div ui-view></div>
		<hr>
		<pre>
			$state = {{$state.current.name}}
			$stateParams = {{$stateParams}}
		</pre>
<@macro.showFooter />
