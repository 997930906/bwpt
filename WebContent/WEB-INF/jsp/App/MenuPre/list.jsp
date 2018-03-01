<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<title>MessageManager</title>
<link rel="stylesheet"
	href="${ctx}/plugs/bootstrap/css/bootstrap-cerulean.min.css" />
<link rel="stylesheet" href="${ctx }/plugs/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/homePage.css">
<style>
	.col-xs-3 { width:20%;}
	.cus-menu{ font-size:11px;}
	.cus-hst{ font-size:11px;color:gray}
	li{ list-style-type: none; }
	a{ 
	text-decoration:none; 
	color:#333; 
	}
</style>
</head>
<body>
	<div class="container-fluid">
			<!--足迹  -->
			<div class="container" style="margin-top:10px"">
				<div class="row">
					<a class="cus-hst">足迹</a>&nbsp;
					<a class="cus-hst">生产计划</a>&nbsp;
					<a class="cus-hst">认识发展</a>&nbsp;
					<a class="cus-hst">特殊工作</a>&nbsp;
					<a class="cus-hst">日常工作</a>&nbsp;
					<a class="cus-hst">记录报表</a>
				</div>
			</div><br>
			<div>
				<button id="menu_autoSet_btn" type="button"
					class="btn btn-default btn-sm" >
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					自定义
				</button>
			</div>
		<div class="row">
			<!-- main -->
				<form name="amform" method="post">

					<c:forEach items="${results}" var="o" varStatus="status">
						<c:if test="${o.rank le 2}"> 
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail">
									 
										<a href="${ctx}/appMenuAction_pslist.action?parentId=${o.id}"> 
											<img src="${ctx}/source/appMenu/${o.path}"
											 	alt="未找到图标">
								     
								</div>
								<p align="center" class="cus-menu">${o.name}</p>
							</div>
						</c:if>
						<c:if test="${o.rank eq 3}">
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail">
							     	<img src="${ctx}/source/appMenu/${o.path}"
									 	alt="未找到图标">
								    
								</div>
								<p align="center" class="cus-menu">${o.name}</p>
							</div>
						 </c:if> 
					</c:forEach>
				</form>
		</div><hr>
		
		<div >
		     <div style="float:left"><strong style="color:blue;">公司新闻：</strong>
		     </div>
		     <div id="demo" style="overflow:hidden;height:22px;line-height:22px;">
			    <ul class="mingdan" id="holder">
			      <li><a href="1.html" target="_self">亚太北区法律及企事业副总裁寄语</a></li>
			      <li><a href="2.html" target="_self">重要合规政策提醒</a></li>
			      <li><a href="3.html" target="_self">champions活动亮点</a></li>
			     
			    </ul>
		     </div>
		</div>
	<!-- 	<div>  
	<ul id="jkTree" class="ztree">
	
	</ul>  
</div> -->
	</div>
	<%-- <%@ include file="public/menuModal.jsp" %> --%>
	<!-- 自定义 modal -->
	<div class="modal fade" id="autoMenuModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">自定义菜单</h4>
				</div>
				<div class="modal-body">
					<form action="appMenuAction_changeAppMenu.action" id="autoMenu_Form" method="post">
						<input type="hidden" id="checkedIds" name="checkedIds" value="" />
						<div>  
							<ul id="jkTree" class="ztree">
							</ul>  
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="menu_saveAutoMenu_btn">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- js -->
	<script type="text/javascript"
		src="${ctx}/plugs/bootstrap/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/plugs/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx }/plugs/zTree/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="${ctx }/plugs/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/homePage.js"></script>
	<script type="text/javascript">
		function AutoScroll(obj) {
		    $(obj).find("ul:first").animate({
		        marginTop: "-22px"
		    },
		    500,
		    function() {
		        $(this).css({
		            marginTop: "0px"
		        }).find("li:first").appendTo(this);
		    });
		}

		$(function(){
			$('#myCarousel').carousel({interval:2000});//每隔5秒自动轮播 
			   setInterval('AutoScroll("#demo")', 3000);
			 	
		});
		
		/*自定义菜单数  */
		var zTreeObj;
		var setting = {
			check : {
				enable : true
			},
			data : {
				simpleData : {
					enable : true
				}
			}
		};
		//点击新增
		$("#menu_autoSet_btn").click(function(){
				 //ajax请求用户的菜单
				  var url = "${ctx}/appMenuAction_findAutoMenu.action";
				  var param = {"rank":"${results[0].rank}"};
				  $.post(url,param, function(data){
				      $(data).each(function(i,n){
				    	  zTreeObj = $.fn.zTree.init($('#jkTree'), setting, data);	//jkTree 树的id，支持多个树
						  zTreeObj.expandAll(true);		//展开所有树节点
						});  
				           },
					  "json"
					); 
				  
				 $("#autoMenuModel").modal({
					backdrop:"static"
				}); 
		});
		//获取所有选择的节点
		function submitCheckedNodes() {
			var nodes = new Array();
			nodes = zTreeObj.getCheckedNodes(true);		//取得选中的结点
			var str = "";
			for (i = 0; i < nodes.length; i++) {
				if (str != "") {
					str += ",";
				}
				str += nodes[i].id;
			}
			$('#checkedIds').val(str);
		}
		
		$("#menu_saveAutoMenu_btn").click(function(){
			submitCheckedNodes();
			$("#autoMenu_Form").submit();
		});
	</script>
	</script>
</body>
</html>