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

				<h2>基本情報</h2>
				<form:form modelAttribute="createConfForm" method="post"
					class="form-horizontal"
					action="${pageContext.request.contextPath}/confpaper/createNewConf">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<td>協議先</td>
							<td>ｘｘｘｘ分会</td>
							<td>通番</td>
							<td>&nbsp; NO.</td>
							<td>メール</td>
							<td>有</td>
							<td>2014年7月7日</td>
						</tr>
						<tr>
							<td rowspan="2" align="center">所属</td>
							<td rowspan="2" colspan="4">xxxx株式会社<br>&nbsp; ｘｘｘｘビル
								&nbsp; xx階<br>&nbsp; ｘｘｘｘ事業部<br>&nbsp;
								xxxxxxxx部 xxxxxxxx課 
							</td>
							<td align="center">所属長</td>
							<td align="center"><spring:message code="label.common.supervisor" /></td>
						</tr>
						<tr>
							<td align="center">連絡者<br>電話
							</td>
							<td align="center">○○○○<br>111-2222-3333
							</td>
						</tr>
					</tbody>
				</table>
				
					<h2>理由</h2>
					<form:textarea path="reason" rows="8" cols="60" />

					<h2>対象者及び対象日等</h2>
					 <form:errors path="*" element="div" cssClass="error-message-list" />
					 <t:messagesPanel />
					<!-- <form:errors path="empInd[0].empName" />  -->
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="empInd-table" width="100%">
							<thead>
								<tr>
									<th width="19%">氏名（氏名コード）</th>
									<th width="14%">対象日（曜日）</th>
									<th width="5%">区分</th>
									<th width="18%">実施予定時間</th>
									<th width="12%">変更日（曜日）</th>
									<th width="9%">月累計時間数</th>
									<th width="9%">年間累計時間数</th>
									<th width="14%">備考</th>
								</tr>
							</thead>
							<tbody id="empInd-tbody">
								<c:forEach items="${createConfForm.empInd}" varStatus="status">
									<tr>
										<td width="18%"><form:input
												path="empInd[${status.index}].empName" style="float:left;"
												size="5" />
											<form:input path="empInd[${status.index}].empNum"
												style="float:left;" size="5" /></td>
										<td width="12%"><form:input
												path="empInd[${status.index}].targetDay" size="7" /></td>
										<td width="5%"><form:input
												path="empInd[${status.index}].divisionCode" size="1" /></td>
										<td width="18%"><form:input
												path="empInd[${status.index}].scheduledTimeStart" size="2" />～<form:input
												path="empInd[${status.index}].scheduledTimeFinish" size="2" /></td>
										<td width="12%"><form:input
												path="empInd[${status.index}].changeDay" size="7" /></td>
										<td width="8%"><form:input
												path="empInd[${status.index}].monthTotalHour" size="3" /></td>
										<td width="8%"><form:input
												path="empInd[${status.index}].yearTotalHour" size="3" /></td>
										<td width="12%"><form:input
												path="empInd[${status.index}].notes" size="4" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<input type="button" value="行追加" onclick="addList();" class="btn btn-default btn-sm" >
					<input type="button" value="行削除" onclick="removeList();" class="btn btn-warning btn-sm" >
					<br>
					<br>
					<input type="submit" name="submit" value="登録"
						class="btn btn-primary">
				</form:form>
				
			</div>
			<div class="col-sm-1 col-xs-0"></div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/tablehandle7.js"></script>
</body>
</html>