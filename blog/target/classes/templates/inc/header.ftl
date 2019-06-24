<!-- Header BEGIN -->
<div class="top-wrap">
    <nav class="navbar navbar-inverse" role="navigation">
<!--[if lt IE 9]>
<div class="alert alert-danger alert-dismissible fade in" role="alert" style="margin-bottom:0">
      <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
      <strong>您正在使用低版本浏览器，</strong> 在本页面的显示效果可能有差异。
        建议您升级到
        <a href="http://www.google.cn/intl/zh-CN/chrome/" target="_blank">Chrome</a>
        或以下浏览器：
        <a href="www.mozilla.org/en-US/firefox/‎" target="_blank">Firefox</a> /
        <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> /
        <a href="http://www.opera.com/" target="_blank">Opera</a> /
        <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie" target="_blank">Internet Explorer 9+</a>
</div>
<![endif]-->
    	<div class="container">
    		<div class="navbar-header">
    			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    				<span class="sr-only">Toggle navigation</span>
    				<span class="icon-bar"></span>
    				<span class="icon-bar"></span>
    				<span class="icon-bar"></span>
    			</button>
    			<a class="navbar-brand logo" href="/index"><img src="/assets/images/logo/logo_full.png"></a>
    		</div>
    		<div id="navbar" class="navbar-collapse collapse">
    			<ul class="nav navbar-nav">
    				<li data="home">
    					<a href="/home/index.html" nav="home">我的主页</a>
    				</li>
					<li>
    					<a href="/g/blog.html" nav="博文">博文</a>
    				</li>
					<li>
    					<a href="/g/web.html" nav="WEB">WEB</a>
    				</li>
					<li>
    					<a href="/g/tutorial.html" nav="教程">教程</a>
    				</li>
					
    			</ul>
    			<div id="_search_box" class="search-box navbar-left hidden-xs hidden-sm">
    				<form class="navbar-form" method="get" action="/search">
    					<input type="text" class="form-control" name="q" placeholder="搜索...">
						<button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
    				</form>
    			</div>
    			
    			<ul class="nav navbar-nav navbar-right sign">
					<li class="dropdown">
                        <a href="/post/new" class="publish"><i class="fa fa-magic"></i> 写文章</a>
					</li>
    				<li class="dropdown">
    					<a href="#" class="ava dropdown-toggle" data-toggle="dropdown">
    						<img class="img-circle" src="/assets/images/ava/default.png">
    					</a>
    					<ul class="dropdown-menu" role="menu">
    		                <li>
    		                	<a href="/account/profile" class="ava">
    <img class="img-circle" src="/assets/images/ava/default.png"/>
    		                		<span>小豆丁</span>
    		                	</a>
    		               	</li>
    		                <li class="divider"></li>

								<li><a href="/admin">后台管理</a></li>

    		                <li><a href="/public/logout">退出</a></li>
    		              </ul>
    				</li>
    			</ul>
    		</div>
    	</div>
    </nav>
</div>
<script type="text/javascript">
$(function () {
	$('a[nav]').each(function(){  
        $this = $(this);
        if($this[0].href == String(window.location)){  
            $this.closest('li').addClass("active");  
        }  
    });
});
</script>
