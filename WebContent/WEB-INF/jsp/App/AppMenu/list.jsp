<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
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
	<%@ include file="../../top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@ include file="../../left.jsp"%>
			<!-- main -->
			<div class="col-md-10">
				<form name="icform" method="post">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">App菜单管理 <span style="font-size:13px;">(${results[0].rank}级菜单)</span></h3>
						</div>
						<div class="panel-body">
							<div id="toolbar" class="btn-toolbar cus-main" role="toolbar"
								style="margin-left: 0px;">
								<div class="btn-group">
									<button id="menu_add_btn" type="button"
										class="btn btn-primary btn-sm" >
										<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										新增
									</button>
									<%-- <button id="btn_delete" type="button"
										class="btn btn-success btn-sm" onclick="editSelect()">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
										修改
									</button> --%>
									<button  type="button"
										class="btn btn-info btn-sm" id="menu_delete_btn">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										删除
									</button>
									<button id="btn_delete" type="button"
										class="btn btn-default btn-sm" onclick="showAll();">
										<span class="glyphicon glyphicon-step-backward"
											aria-hidden="true"></span> 显示全部
									</button>

								</div>
							</div>
							<div style="margin-top: 15px;">
								<div class="row">
									<c:forEach items="${results}" var="o" varStatus="status">
										<div class="col-md-1" style="text-align: center;">
											 <c:if test="${o.rank le 2}"> 
												<a href="${ctx}/appMenuAction_slist.action?parentId=${o.id}"> 
													<img src="${ctx}/source/appMenu/${o.path}"
														alt="图片" style="width: 40px; height: 30px;">
												</a>
												<div class="caption">
													<label >
													<p style="font-size: 10px;"><input type="checkbox" name="check" value="${o.id}">${o.name}</p>
													</label>
												</div>
											 </c:if> 
											 <c:if test="${o.rank eq 3}"> 
													<img src="${ctx}/source/appMenu/${o.path}"
														alt="图片" style="width: 40px; height: 30px;">
												<div class="caption">
													<label >
													<p style="font-size: 10px;"><input type="checkbox">${o.name}</p>
													</label>
												</div>
											 </c:if> 
										</div>
									</c:forEach>
								</div>
								<div class="row">${links}</div>

							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="public/menuModal.jsp" %>

	<!-- js -->
	<script type="text/javascript"
		src="${ctx}/plugs/bootstrap/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/plugs/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/homePage.js"></script>
	<script type="text/javascript">
		function showAll(){
			location.href="${ctx}/appMenuAction_list.action";
		}
		//点击新增
		$("#menu_add_btn").click(function(){
			$("#addMenuModel").modal({
				backdrop:"static"
			});
		});
		//保存新增
		$("#menu_save_btn").click(function(){
			 if(!validate_add_form()){
				return false;
			}; 
			alert(1);
			$("#insertForm").submit();
			//2、发送ajax请求保存
			/*$.ajax({
				url:"${ctx}/emp",
				type:"POST",
				data:$("#empAddModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					if(result.code == 100){
						//员工保存成功；
						//1、关闭模态框
						$("#empAddModal").modal('hide');
						
						//2、来到最后一页，显示刚才保存的数据
						//发送ajax请求显示最后一页数据即可
						to_page(totalRecord);
					}else{
						//显示失败信息
						//console.log(result);
						//有哪个字段的错误信息就显示哪个字段的；
						if(undefined != result.extend.errorFields.email){
							//显示邮箱错误信息
							show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
						}
						if(undefined != result.extend.errorFields.empName){
							//显示员工名字的错误信息
							show_validate_msg("#empName_add_input", "error", result.extend.errorFields.empName);
						}
					}
				}
			}); */
		});
		//校验表单数据
		function validate_add_form(){
			//1、拿到要校验的数据，使用正则表达式
			var empName = $("#add_title").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#add_title", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			}else{
				alert(12);
				/* show_validate_msg("#add_title", "success", ""); */
				return true;
			};
		}
		//显示校验结果的提示信息
		function show_validate_msg(ele,status,msg){
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success"==status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error" == status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//删除
		$("#menu_delete_btn").click(function(){
			var flag = false;
	 	    var ids=[];
	 	    var count = 0;
	 	    var de = document.getElementsByName("check");
	 	    for(i=0;i<de.length;i++) {
	 	        if(de[i].checked){
	 	                ids.push(de[i].value);
	 	                count+=1; 
	 	                flag= true;
	 	        }
	 	    }
	 	    if(flag==false) {
	 	        alert("至少你要选择一个待删除记录");
	 	        return false;
	 	    }
	 	    if(confirm("您选中了["+count+"] 条记录，确定删除？")){
	 	    	var url = "${ctx}/appMenuAction_deleteByIds";
	  		   	var param = {'ids' : ids.toString()}; 
	  		   	
	  		   	$.post(url,param, function(data){
	  			   alert("删除成功!");
	  			   location.reload();  
	  		 		},
	    		 	  "json");
	 	    }
		});
	</script>
</body>
</html>