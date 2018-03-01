<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-inner">
			<a class="navbar-brand" href="#"> MessageManager
			</a>

			<!-- user dropdown starts -->
			<div class="btn-group pull-right ">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i><span
						class="hidden-sm hidden-xs"> 后台管理</span> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="javascript:void(0);"> 用户名</a></li>
					<li class="dilider"></li>
					<li class="divider"></li>
					<li><a href="#" data-toggle="modal"
						data-target="#editPswModal">修改密码</a></li>
					<li><a href="${pageContext.request.contextPath}/login.html">退出系统</a></li>
				</ul>
			</div>
			<!-- user dropdown ends -->

		</div>
		<!--navbar-inner  -->
	</div>