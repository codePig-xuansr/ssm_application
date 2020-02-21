<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
	<link href="../css/style2.css" rel="stylesheet" type="text/css">

<link href="../js/My97DatePicker/SKIN/WdatePicker.css" rel="stylesheet" type="text/css">

<style type="text/css">
	body{background: color:#fff;}
</style>

</head>
<body>
	
	<div class="action  divaction" id="${sessionScope.user.employeeId }">
		<div class="t" id="${sessionScope.user.departmentId }">查看请假</div>
		<div class="pages" id="${sessionScope.user.pId }">
				<!--增加请假单 区域 开始-->
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<caption>基本信息</caption>
					<tbody>
						<tr>
							<td width="36%" class="empname">姓名：${sessionScope.user.employeeName }</td>
							<td width="64%" class="depname">部门：${sessionScope.user.departmentName }</td>
						</tr>
						<tr>
							<td>开始时间：<input type="date" name="startDate" value=""
								id="startDate" class="nwinput"></td>
							<td>结束时间：<input type="date" name="endDate" value=""
								id="endDate" class="nwinput"></td>
						</tr>
						<tr>
							<td>请假天数：
								<input type="hidden" name="totalCount" value="1">
								<span id="totalCount">1</span>
							</td>
						</tr>
						<tr>
							<td colspan="2"><span style="position: relative; top: -30px;">请假事由：</span>
								<textarea id="textarea" name="event" rows="5" cols="45"></textarea></td>
	
						</tr>
	
						<!--表单提交行-->
						<tr>
							<td colspan="4" class="submit">
								<input type="button" value="提交" onclick="toSubmit()" class="submit_01">
								<input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01">
							</td>
						</tr>
					</tbody>
				</table>
		</div>
	</div>

</body>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script>
	$(function(){
		$("#startDate").change(function(){
			var sDate = $(this).val();
			var eDate = $("#endDate").val();
			sDate = new Date(sDate.replace(/-/g, "/"));
			if(sDate<new Date()){
				alert("请假日期不正确！");
				$(this).val("");
				return;
			}
			if(eDate != ""){
				eDate = new Date(eDate.replace(/-/g, "/"));
				var days = eDate.getTime() - sDate.getTime();
				var time = parseInt(days / (1000 * 60 * 60 * 24));
				if(time <= 0){
					alert("请选择正确的日期");
					$(this).val("");
					return false;
				}else{
					$("#totalCount").text(time).val(time);
					$("[name='totalCount']").val(time);
				}
			}
		});
		$("#endDate").change(function(){
			var sDate = $("#startDate").val();
			var eDate = $(this).val();
			if(sDate != ""){
				sDate = new Date(sDate.replace(/-/g, "/"));
				eDate = new Date(eDate.replace(/-/g, "/"));
				var days = eDate.getTime() - sDate.getTime();
				var time = parseInt(days / (1000 * 60 * 60 * 24));
				if(time <= 0){
					alert("请选择正确的日期");
					$(this).val("");
					return false;
				}else{
					$("#totalCount").text(time);
					$("[name='totalCount']").val(time);
				}
			}
		});
	});
	
	function toSubmit(){
		let event = $("#textarea").val();
		let startTime=$("[name=startDate]").val();
		let endTime=$("[name=endDate]").val();
		let days=$("#totalCount").text();
		let createman=$("div").eq(0).attr("id");
		let depid=$("div").eq(1).attr("id");
		let nextid=$("div").eq(2).attr("id");
		if(event == ""){
			alert("请输入请假事由");
			return;
		}
		let leave={};
		leave["createMan"]=createman;
		leave["departmentId"]=depid;
		leave["startTime"]=startTime;
		leave["endTime"]=endTime;
		leave["nextDealMan"]=nextid;
		leave["event"]=event;
		leave["totalCount"]=days;
		leave["statusId"]="2";
		$.ajax('/ssm_application/api/leaves/leave',{
			type:"post",
			dataType:"json",
			contentType:"application/json",
			data:JSON.stringify(leave),
			success:function(e){
				location.href='qjList.html';
			}
		})
		
	}
</script>
</html>
