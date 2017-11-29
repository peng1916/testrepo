$(document).ready(function(){
	  if( $.cookie('user_name') != null )
	  {
		  $("#user_name").html($.cookie('user_name'));
		  $("#user_name").html('退出帐号');
	  }
	  else
	  {
		  $("#user_name").html('亲，请登录');
		  $("#user_name").html('免费注册');
	  }
});
