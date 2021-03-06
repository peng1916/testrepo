<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/dlstyle.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/basic/js/jquery-1.7.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		  $("#login_btn").click(function(){
			  if($('#seller').is(':checked')) {
				  $("#role").val('1');
			  }
			  
			  $("#loginForm").submit();				  
		  });
	});

	</script>
</head>
<body>
		<div class="login-boxtitle">
			<a href="${pageContext.request.contextPath}/home/main"><img alt="logo" src="${pageContext.request.contextPath}/images/logobig.png" /></a>
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath}/images/big.jpg" /></div>
				<div class="login-box">
				
					<h3 class="title">登录商城</h3>

					<div class="clear"></div>
						
					<div class="login-form" >
					  <form id="loginForm" action="${pageContext.request.contextPath}/user/login" method="get">
						   <div class="user-name">
							    <label for="user"><i class="am-icon-user" style="height:40px;padding-top:12px"></i></label>
							    <input type="text" name="user" id="user" placeholder="邮箱/手机/用户名">
							    <input type="hidden" name="role" id="role" value="0">
			               </div>
			               <div class="user-pass">
											    <label for="password"><i class="am-icon-lock" style="height:40px;padding-top:12px"></i></label>
											    <input type="password" name="password" id="password" placeholder="请输入密码">
			               </div>
			           </form>
			        </div>
            
		            <div class="login-links">
		            	
		                <label for="remember-me"><input id="buyer" type="checkbox">买家</label>
		                <label for="remember-me"><input id="seller" type="checkbox">卖家</label>
										<a href="#" class="am-fr">忘记密码</a>
										<a href="register.html" class="zcnext am-fr am-btn-default">注册</a>
										<br />
		            </div>
					<div class="am-cf">
						<input type="button" id="login_btn" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm" />
					</div>
					<div class="partner">		
							<h3>合作账号</h3>
						<div class="am-btn-group" style="padding-top:12px">
							<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
							<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
							<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
						</div>
					</div>	
				
				</div>
			</div>
		</div>

					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">恒望科技</a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# ">物流</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# ">关于恒望</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
							</p>
						</div>
					</div>


</body>
</html>