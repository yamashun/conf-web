<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ログインページ</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- message -->
    <link href="${pageContext.request.contextPath}/resources/css/message.css" rel="stylesheet" media="screen">

  </head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top" style="height:80px;">
  		<div class="navbar-header">
  			<a class="nav navbar-brand" href=""><h2>協議書Web</h2></a>
  		</div>
  	</nav>
	
	<div class="container" style="padding:70px 0">
  		<div class="row">
  			<div class="col-sm-3 col-xs-2"></div>
			<div class="col-sm-6 col-xs-8">
				<div id="wrapper">
				
					<form action="${pageContext.request.contextPath}/authenticate"
	            		method="POST" class="form-horizontal" style="margin-bottom:15px; margin-top:30px;" >
				  		<fieldset>
				  			<legend>ログイン</legend>
							<div class="form-group">
								<label class="control-label col-sm-4 col-xs-3" for="j_username">社員番号</label>
								<div class="col-sm-6 col-xs-5">
									<input type="text" id="j_username" name="j_username" class="form-control" value="0000002" required pattern="[0-9]{7}" title="数字7桁" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4 col-xs-3" for="j_password">パスワード</label>
								<div class="col-sm-6 col-xs-5">
									<input type="password" id="j_password" name="j_password" class="form-control" value="demo" required  />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-4">
									<input type="hidden"
	                        			name="${f:h(_csrf.parameterName)}"
	                        			value="${f:h(_csrf.token)}" /> 
									<input type="submit" name="submit" value="Login" class="btn btn-primary">
								</div>
							</div>
						</fieldset>
					</form>
					<t:messagesPanel />
				</div>
			</div>
			<div class="col-sm-3 col-xs-2"></div>
		</div>
	</div>
	    
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>