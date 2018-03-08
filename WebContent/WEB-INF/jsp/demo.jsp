<%@ page language="java" pageEncoding="UTF-8"%>
<%-- <%@ include file="../.. --%>/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MessageManager</title>
<link rel="stylesheet"
	href="${ctx}/plugs/bootstrap/css/bootstrap-cerulean.min.css" />
<link rel="stylesheet" href="${ctx}/css/homePage.css">
</head>
<body>
	<!--顶部  -->
<%-- 	<%@ include file="../../top.jsp"%> --%>
	<div class="container-fluid">
		<div class="row">
			<!-- left -->
		<%-- 	<%@ include file="../../left.jsp"%> --%>
			<!-- main -->
			<div class="col-md-10">
				<form name="icform" method="post">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">机器定义</h3>
						</div>
						<div class="panel-body">
						
						</div>
					</div>
				</form>
			</div>
			
		</div>
	</div>

	<!-- js -->
	<script type="text/javascript"
		src="${ctx}/plugs/bootstrap/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/plugs/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/homePage.js"></script>
	<script type="text/javascript">
	</script>
</body>
</html>