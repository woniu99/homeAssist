<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
    <title>测试HTTP协议体内容</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/test.css">
	<script src="js/jquery-2.0.3.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body class="container">
		<header class="page-header visible-sm visible-md visible-lg text-center">
			<h1>蜗牛家居助手</h1>
		</header>
		<div class="app-location">
		    <div class="row">
                <div class="location"><img src="images/logo7.png" class="img-responsive" alt="Responsive image" /></div>
				<!-- 表单 -->
				<form class="form-horizontal"  action="servlet/servletzxx"  method="post">
					<!-- 用户名 -->
					<div class="form-group has-feedback">
						<label class= "control-label sr-only" for="username">用户名</label>
						<div class="input-group input-group-lg">
                             <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" class="form-control"  name="flag" placeholder="请输入用户名" required>
							<span></span>
						</div>
					</div>
					<!-- 密码 -->
					<div class="form-group has-feedback">
						<label class=" control-label sr-only" for="password">密码</label>
						<div class=" input-group input-group-lg">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" class="form-control" name="password"  placeholder="请输入密码" required>
							<span></span>
						</div>
					</div>
					<!-- 功能按钮 -->
                	<button id="btnSubmit" type="submit" class="btn">登录</button>
					<div class="new">
						<h3><a href="#">忘记密码？</a></h3>
						<h4><a href="signup.jsp">新用户？立即注册 </a></h4>
						<div class="clear"></div>
					</div>	
					<script>
					function checkInput(txt) {
						if(txt.val() == ""){
							txt.parent().parent()
							.removeClass()
							.addClass("form-group has-error has-feedback");
							txt.next().removeClass()
							.addClass("glyphicon glyphicon-warning-sign form-control-feedback");
							return false;
						} else {
							txt.parent().parent()
							.removeClass()
							.addClass("form-group has-success has-feedback");
							txt.next().removeClass()
							.addClass("glyphicon glyphicon-ok form-control-feedback");
							return true;
						}
					}

						$(function() {
							$("#username").change(function() { checkInput($("#username"));});
							$("#password").change(function() { checkInput($("#password"));});
							$("#btnSubmit").click(function(){

								if(checkInput($("#username"))  && checkInput($("#password"))) {
									return true;
								} 
								return false;
							});
						});
					</script>
				</form>	
		    </div>	
		</div>
		<footer class="text-center copy-right">
			<p>Copyright&copy;2016.</p>
		</footer>
	</body>
</html>
