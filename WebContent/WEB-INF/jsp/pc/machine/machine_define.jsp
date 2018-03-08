<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MessageManager</title>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
        rel="stylesheet">
<%-- <link href="${ctx}/plugs/font-awesome/font-awesome.css" rel="stylesheet"> --%>
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="${ctx}/plugs/bootstrap/css/bootstrap-cerulean.min.css" />
<link rel="stylesheet" href="${ctx}/css/homePage.css">
<style type="text/css">
.shortcuts {
	text-align: center;	
}

.shortcuts .shortcut { 
	width: 22.50%;
	display: inline-block;
	padding: 12px 0;
	margin: 0 .9% 1em;
	vertical-align: top;	
	
	text-decoration: none;
	
	background: #f9f6f1;
	
	border-radius: 5px;
}

.shortcuts .shortcut .shortcut-icon {
	margin-top: .25em;
	margin-bottom: .25em;
	
	font-size: 32px;
	/* color: #545454; */
}

.shortcuts .shortcut:hover {
	background: #34A6E7;
}

.shortcuts .shortcut:hover span{
	color: #fff;
}

.shortcuts .shortcut:hover .shortcut-icon {
	color: #fff;
}

.shortcuts .shortcut-label {
	display: block;
	
	font-weight: 400;
	color: #545454;
}
</style>
</head>
<body>
	<!--顶部  -->
	<%@ include file="../../top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<!-- 第一列 -->
			<div class="col-md-8">
				<div style="height: 600px;" id="page1">
					<canvas id="canvas" style="position: absolute" tabindex="0"></canvas>
				</div>
			</div>
			
					<!--第2列 -->
				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading"> 
							<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 
							<b>报警汇总信息</b>
						</div>
						<div class="panel-body shortcuts">
						    <a href="javascript:;" class="shortcut">
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">ICM</span> 
							</a>
							<a href="javascript:;" class="shortcut">
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">SEQU</span> 
							</a>
							<a href="javascript:;" class="shortcut">
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">AI/AO</span> 
							</a>
							<a href="javascript:;" class="shortcut"> 
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">MANUAL</span> 
							</a>
							<a href="javascript:;" class="shortcut">
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">SIMULATION</span> 
							</a>
							<a href="javascript:;" class="shortcut">
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">PID</span>
							</a>
							<a href="javascript:;" class="shortcut">
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">INTERLOCK</span> 
							</a>
							<a href="javascript:;" class="shortcut">
								<i><img src="${ctx}/source/appMenu/ES.png" width="32px" height="32px"></i>
								<span class="shortcut-label">OTHERS</span> 
							</a> 
					    </div>
					</div>
					
					
					<div class="panel panel-default">
						<div class="panel-heading"> <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> <b>操作提示信息</b></div>
						<div class="panel-body ">
							<div style="background:#dfd;">提供额外的视觉效果，标识一组按钮中的原始动作</div> <br>
							<div style="background:#fdd;">提供额外的视觉效果，标识一组按钮中的原始动作</div> <br>
							<div style="background:#ffd;">提供额外的视觉效果，标识一组按钮中的原始动作</div> <br>
							<div style="background:#ddd;">提供额外的视觉效果，标识一组按钮中的原始动作</div>  <br>
							<div style="background:#ffd;">提供额外的视觉效果，标识一组按钮中的原始动作</div> <br>
							<div style="background:#ffd;">提供额外的视觉效果，标识一组按钮中的原始动作</div> <br>
							<div style="background:#ffd;">提供额外的视觉效果，标识一组按钮中的原始动作</div> 
					    </div>
					</div>
					
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
		var ccanvas = document.getElementById('canvas'); // 得到画布
		var cContext = ccanvas.getContext('2d'); // 得到画布的上下文对象
		var url_bg = "${ctx}/source/test.png";
		var bg="#fff url("+url_bg+") no-repeat top left";
		ccanvas.style.background=bg;
		ccanvas.style.backgroundSize ="100% 100%";
		
		window.addEventListener("resize", resizeCanvas, false);
		function resizeCanvas() {
			//alert($('#page1').width());
			//alert(window.innerHeight);
		    w = ccanvas.width = $('#page1').width();
		    h = ccanvas.height =  $('#page1').height();
		    
		    resizeDraw();
		}
		$(function(){
			resizeCanvas();
		});
	</script>
</body>
</html>