<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>订单采购</title>
	
	<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/cartstyle.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/optstyle.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
	
	
		<script type="text/javascript">
	$(document).ready(function(){
		  if( $.cookie('user_name') != null )
		  {
			  //alert($.cookie('user_name'));
			  $("#user_name").html($.cookie('user_name'));
			  $("#user_register").html('退出帐号');
			  
				var user_id = $.cookie('user_id');
				if( user_id == null )
				{
					alert("请登录！");
					return;
				}

				var xmlhttp;
				if (window.XMLHttpRequest)
				{// code for IE7+, Firefox, Chrome, Opera, Safari
				  xmlhttp=new XMLHttpRequest();
				}
				else
				{// code for IE6, IE5
				  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				
				xmlhttp.onreadystatechange=function()
				{
				  if (xmlhttp.readyState==4 && xmlhttp.status==200)
				  {
					  $("#J_MiniCartNum").html(xmlhttp.responseText);
				  }
				}
				xmlhttp.open("GET","${pageContext.request.contextPath}/shopcart/" + user_id + "/purchase",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send();
		  }
		  else
		  {
			  //alert($.cookie('user_name'));
			  $("#user_name").html('亲，请登录');
			  $("#user_register").html('免费注册');
		  }
	});

	</script>
	
</head>
<body>
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a id="user_name" href="${pageContext.request.contextPath}/user/welcome" target="_top" class="h">亲，请登录</a>
						<a id="user_register" href="${pageContext.request.contextPath}/user/welcome" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="${pageContext.request.contextPath}/shopcart/25/detail" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>采购单</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="${pageContext.request.contextPath}/images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="${pageContext.request.contextPath}/images/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>

			<!--采购单 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
								<div class="bd-promos">
									<!-- 
									<div class="bd-has-promo">金秋优惠:<span class="bd-has-promo-content"></span>&nbsp;&nbsp;</div>
									<div class="act-promo">
										<a href="#" target="_blank">第二支半价，第三支免费<span class="gt">&gt;&gt;</span></a>
									</div>
									<span class="list-change theme-login">编辑</span>
									 -->
								</div>
							</div>
							<div class="clear"></div>
							<div class="bundle-main">

								
								
								<c:forEach var="product" items="${products}" varStatus="status">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="${product.id}" name="items[]" value="${product.id}" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="${pageContext.request.contextPath}/images/${product.distImageUrl1}" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色" class="item-title J_MakePoint" data-point="tbcart.8.11">${product.name} ${product.description}</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props">
											<span class="sku-line">${product.categoryId}</span>
											<span class="sku-line">${product.size}</span>
											<i class="theme-login am-icon-sort-desc"></i>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">${product.price}</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" />
													<input id="quantity_${product.id}"  class="text_box" name="" type="text" value="${productNums[status.index]}" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number">${product.price*productNums[status.index]}</em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="移入收藏夹" class="btn-fav" href="#">
                  移入收藏夹</a>
											<a href="javascript:;" data-point-url="#" class="delete">
                  删除</a>
										</div>
									</li>
								</ul>
													
							    </c:forEach>
								
								
							</div>
						</div>
					</tr>
					<div class="clear"></div>

					<tr class="item-list">

					</tr>
				</div>
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
							<label for="J_SelectAllCbx2"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						POS单号：
<!-- 						<input id="pos_no" type="text"></input> -->
<!-- 						代购地点：<input id="pos_cntry" type="text"></input> -->
						<select id="pos_select" class="selector" style="font-size:16px">
							<c:forEach var="pos_detail" items="${pos_details}" varStatus="status">
								<option value="${pos_detail}">${pos_detail}</option>
							</c:forEach>
						  <option value="164706698491,2017-10-15 11:47:06,美国">164706698491,2017-10-15 11:47:06,美国</option>
						  <option value="164706698492,2017-11-05 16:47:06,美国">164706698492,2017-11-05 16:47:06,美国</option>
						  <option value="164706698493,2017-11-21 16:47:06,美国">164706698493,2017-11-21 16:47:06,美国</option>
						  <option value="164706698494,2017-11-25 10:47:06,中国">164706698494,2017-11-25 10:47:06,中国</option>
						</select>
<!-- 						<a href="#" hidefocus="true" class="deleteAll">删除</a> -->
<!-- 						<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a> -->
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">0.00</em></strong>
						</div>
						<div class="btn-area">
							<a href="#" id="J_Go" onclick="check_items()" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span id="check_and_sell">验证&nbsp;上货</span></a>
						</div>
					</div>

				</div>
				
				<div id="result_panel" class="float-bar-wrapper" style="height:50px;padding-left:100px;padding-top:12px;display:none">
					<label id="check_result">验证通过，上货成功！</label>><a id="check_detail" href="#">查看详情</a>
				</div>
				
				<script type="text/javascript">
				function check_items(){
					var pos = $(".selector").val();
// 					var selectText=$("#pos_select").find("option:selected").val();
// 					alert(pos);
// 					alert(selectText);
// 					alert($(".selector").find("option:selected").text());
					
					var product_ids = "";
					var quantity_nums = "";
					var quantity = "";
					$('input:checkbox:checked').each(function (index, item) {
						quantity = "quantity_" + $(this).val();
						var test = document.getElementById(quantity).value;
						
						product_ids = product_ids + $(this).val() + ",";
						quantity_nums = quantity_nums + test + ",";
					});

					var xmlhttp;
					if (window.XMLHttpRequest)
					{// code for IE7+, Firefox, Chrome, Opera, Safari
					  xmlhttp=new XMLHttpRequest();
					}
					else
					{// code for IE6, IE5
					  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
					
					xmlhttp.onreadystatechange=function()
					{
					  if (xmlhttp.readyState==4 && xmlhttp.status==200)
					  {
						  //alert(xmlhttp.responseText);
						  var return_id = xmlhttp.responseText;
						  if( return_id > 0 )
						  {
							  $("#check_result").html("验证通过，上货成功！");
							  //alert("${pageContext.request.contextPath}/check/" + xmlhttp.responseText + "/detail");
							  $("#check_detail").attr("href","${pageContext.request.contextPath}/check/" + xmlhttp.responseText + "/detail"); 
							  var tmp = xmlhttp.responseText;
							  var length = tmp.length;
							  var final_str = tmp.substring( 1, length );
							  //alert(final_str);
							  //$("#check_detail").attr("href","${pageContext.request.contextPath}/check/" + result_id_pos + "/detail"); 
						  }
						  else
						  {
							  $("#check_result").html("验证未通过，上货失败！");
							  
							  //var result_id_pos = -1 * result_id;
							  //$("#check_detail").attr("href","${pageContext.request.contextPath}/check/" + result_id_pos + "/detail"); 
						  }
						  //alert("here");
						  $("#result_panel").css("display", "block");
					  }
					}
					
					//var param = "pos_no=" + pos_no + "&pos_cntry=" + pos_cntry + "&product_ids=" + product_ids + "&quantity_nums=" + quantity_nums;
					var param = "pos=" + pos + "&product_ids=" + product_ids + "&quantity_nums=" + quantity_nums;
					xmlhttp.open("POST","${pageContext.request.contextPath}/check/result",true);
					xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xmlhttp.send("pos=" + pos + "&product_ids=" + product_ids + "&quantity_nums=" + quantity_nums);
				}
	
				</script>

				<%@include file="/WEB-INF/jsp/common/footer.jsp" %>

			</div>

		<!--引导 -->
		<div class="navCir">
			<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>采购单</a></li>	
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>

</body>
</html>