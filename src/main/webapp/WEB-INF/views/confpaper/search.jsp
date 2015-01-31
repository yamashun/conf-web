<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Top</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link
	href="${pageContext.request.contextPath}/resources/css/confpaper.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath}/resources/css/message.css"
	rel="stylesheet" type="text/css" media="all" />


</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top"
		style="height: 80px;">
		<div class="navbar-header">
			<a class="nav navbar-brand" href=""><h1>協議書Web</h1></a>
		</div>

		<div class="collapse navbar-collapse target">
			<ul class="nav navbar-nav navbar-right"
				style="margin-top: 40px; margin-right: 20px;">
				<li><sec:authentication property="principal.account"
						var="account" />
					<div class="btn-group">
						<button class="btn btn-primary dropdown-toggle"
							data-toggle="dropdown">
							ユーザ：${f:h(account.employeeNum)} <span class="caret">
						</button>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/logout">ログアウト</a>
							<li>
							<li class="divider">
							<li>
							<li><a href="">パスワード変更</a>
							<li>
						</ul>
					</div></li>
			</ul>
		</div>
	</nav>
	<br />

	<div class="container" style="padding: 70px 0">
		<div class="row">
			<div class="col-sm-1 col-xs-0"></div>
			<div class="col-sm-10 col-xs-12">
				<h2>メインメニュー</h2>
				&nbsp;&nbsp;&nbsp;
				<button class="btn btn-primary">
					<i class="glyphicon glyphicon-pencil"></i> 登録
				</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary">
					<i class="glyphicon glyphicon-search"></i> 一時保存
				</button>

				<h2>検索</h2>
				<form:form modelAttribute="searchForm" method="GET"
					class="form-horizontal"
					action="${pageContext.request.contextPath}/searchconf/search">
					<table class="table table-striped table-bordered table-hover"
							id="search-table">
							<tbody id="search-tbody">
									<tr>
										<td><spring:message code="label.search.submitperson" /></td>
										<td><form:input path="submitPerson" size="12" value="連絡者" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.search.practitioner" /></td>
										<td><form:input path="practitioner" size="12" value="demo" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.search.employeenum" /></td>
										<td><form:input path="employeeNum" size="12" value="0000002" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.search.targetday" /></td>
										<td><form:input path="targetDay" size="12" value="2014/10/10" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.search.status" /></td>
										<td><form:input path="status" size="12" value="01" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.search.confpaperno" /></td>
										<td><form:input path="confPaperNo" size="12" /></td>
									</tr>
							</tbody>
						</table>
						<input type="submit" name="submit" value="検索"
						class="btn btn-primary">
					</form:form>
				
					
				<h2>検索結果</h2>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>No</th>
							<th>対象日</th>
							<th>ステータス</th>
							<th>社員コード</th>
							<th>申請者</th>
							<th>種別</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${resultList}" var="confNum" varStatus="count">
							<tr>
								<td>${f:h(confNum.confPaperNo)}</td>
								<td><fmt:formatDate value="${confNum.targetDay}"
										pattern="yyyy/MM/dd" /></td>
								<td>${f:h(confNum.status)}</td>
								<td>${f:h(confNum.employeeNum)}</td>
								<td>${f:h(confNum.practitioner)}</td>
								<td>${f:h(confNum.submitPerson)}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				
			</div>
			<div class="col-sm-1 col-xs-0"></div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"></script>
</body>
</html>