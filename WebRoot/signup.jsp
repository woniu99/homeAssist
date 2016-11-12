<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>智能家居-注册</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/test.css">
		<script src="js/jquery-2.0.3.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>
	<body class="container">
		<header class="page-header visible-sm visible-md visible-lg text-center">
			<h1>蜗牛家居助手</h1>
		</header>
		<div class="app-location test2">
		    <div class="row">
                <div class="h2-title">
                    用户注册
                </div>
				<!-- 表单 -->
				<form class="form-horizontal row" method="get" action="servlet/servletzxx">
					<!-- 用户名 -->
					<div class="form-group has-feedback">
						<label class= "control-label control-label-lg col-md-3" for="username">用户名：</label>
						<div class="input-group input-group-lg col-md-9">
                             <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" class="form-control" name="flag"  placeholder="请输入用户名" required>
							<span></span>
						</div>
					</div>
                    <!-- 邮箱 -->
					<div class="form-group has-feedback">
						<label class=" control-label col-md-3" for="email">邮 箱：</label>
						<div class=" input-group input-group-lg col-md-9">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
							<input type="email" class="form-control" id="email" placeholder="请输入邮箱" required>
							<span></span>
						</div>
					</div>
					<!-- 密码 -->
					<div class="form-group has-feedback">
						<label class=" control-label col-md-3" for="password">密 码：</label>
						<div class=" input-group input-group-lg col-md-9">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" class="form-control" placeholder="请输入密码" required>
							<span></span>
						</div>
					</div>
                    <!-- 密码 -->
					<div class="form-group has-feedback">
						<label class=" control-label col-md-3" for="password">确认密码：</label>
						<div class=" input-group input-group-lg col-md-9">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" class="form-control" name="password" placeholder="请输入密码" required>
							<span></span>
						</div>
					</div>
					<!-- 功能按钮 -->
                    <div class="login-up">
                        <button id="btnSign" type="submit" class="btn">注册并登陆</button>
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
							$("#email").change(function() { checkInput($("#email"));});
							$("#username").change(function() { checkInput($("#username"));});
							$("#password").change(function() { checkInput($("#password"));});

							$("#btnSubmit").click(function(){

								if(checkInput($("#email")) && checkInput($("#username"))  && checkInput($("#password"))) {
									alert("恭喜你！注册成功！");
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
