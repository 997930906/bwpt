<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 新增 modal -->
<div class="modal fade" id="addMenuModel" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新增</h4>
			</div>
			<div class="modal-body">
				<form action="appMenuAction_insert" id="insertForm" method="post"
					enctype="multipart/form-data" >
					<div class="form-group">
						<label for="title">菜单名：</label> 
						<input type="text" name="name" id="add_title" class="form-control" placeholder="请输入菜单名">
						<span class="help-block"></span>
						<input type="hidden" name="parentId" value="${results[0].parentId}">
						<input type="hidden" name="rank" value="${results[0].rank}">
					</div>
					<div class="form-group">
						<div class="report-file">
							
							<span>上传图标…</span> <input tabindex="3" size="3" name="upload"
								class="file-prew" type="file"
								onchange="document.getElementById('textName').value=this.value">
						</div>
						<input type="text" id="textName"
							style="height: 28px; width:100px;border: 1px solid #f1f1f1" />
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="menu_save_btn">保存</button>
			</div>
		</div>
	</div>
</div>
<!--新增 ends  -->

<!-- 修改 modal -->
<div class="modal fade" id="editImg" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改</h4>
			</div>
			<div class="modal-body">
				<form action="img_edit" id="editForm" method="post"
					enctype="multipart/form-data">
					<%-- 	<div class="input-group cus-MarginTop">
								<span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
								<input type="hidden" id="hiddenId" name="img_id"/>
								<input type="hidden" id="hiddenPath" name="img_path"/>
								<input type="text" class="form-control"  id="edit-title" placeholder="标题" name="img_title" 
								 aria-describedby="sizing-addon1">
							</div> --%>
					<div class="form-group">
						<input type="hidden" id="hiddenId" name="img_id" /> <input
							type="hidden" id="hiddenPath" name="img_path" /> <label
							for="edit-title">标题：</label> <input type="text" name="img_title"
							id="edit-title" class="form-control" placeholder="标题">
					</div>
					<div class="form-group">
						<label for="edit-content">图片内容：</label> <input type="text"
							name="img_content" id="edit-content" class="form-control"
							placeholder="标题">
					</div>
					<div class="form-group">
						<label for="edit-longtitude">经度：</label> <input type="text"
							name="longtitude" id="edit-longtitude" class="form-control"
							placeholder="标题">
					</div>
					<div class="form-group">
						<label for="edit-latitude">纬度：</label> <input type="text"
							name="latitude" id="edit-latitude" class="form-control"
							placeholder="标题">
					</div>
					
					<div class="form-group cus-MarginTop">
					    <label for="eqkName">选择所属地震事件</label>
					    <select class="form-control" id="eqk_edit"  name="eqkName">
					    </select>
				    </div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary"
					onclick="editFormSave()">保存</button>
			</div>
		</div>
	</div>
</div>



