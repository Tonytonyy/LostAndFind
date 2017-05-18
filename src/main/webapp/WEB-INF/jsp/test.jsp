<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:set var="picPath" value="http://127.0.0.1:8003/ssmImage19"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.form.js"></script>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="${pageContext.request.contextPath }/static/css/mui.min.css" rel="stylesheet" />
	</head>
   <body>
    <script src="${pageContext.request.contextPath }/static/js/mui.min.js"></script>
    <style type="text/css">
    .cancelstyle{
       background:none; 
       outline:none;   
       border:0px; 
       color:white;
                 }
    .imagehw{
      width:90px;
      height:26%}
    </style>
	<script type="text/javascript">
		//	mui.init()
	</script>

     <form class="mui-input-group" action="http://localhost:8080/org.zsl.hnust/user/upload" method="post" enctype="multipart/form-data">
    <div class="mui-input-row">
        <label>标题</label>
    <input type="text" class="mui-input-clear" placeholder="请输入用户名"/>
    </div>
    <div class="mui-input-ranges" style="margin: 10px 10px 20px 20px ">
      <img id='imgSize1ImgSrc' src='http://pic.baike.soso.com/ugc/baikepic2/23286/20170222094747-2048932296.jpg/0' class="imagehw" />
      <img id='imgSize1ImgSrc1' src='http://pic.baike.soso.com/ugc/baikepic2/23286/20170222094747-2048932296.jpg/0' class="imagehw" />
      <img id='imgSize1ImgSrc2' src='http://pic.baike.soso.com/ugc/baikepic2/23286/20170222094747-2048932296.jpg/0' class="imagehw" />
      <img id='imgSize1ImgSrc3' src='http://pic.baike.soso.com/ugc/baikepic2/23286/20170222094747-2048932296.jpg/0' class="imagehw" />
    </div>

  </div>
    	<div class="mui-input-range" style="margin: 10px 10px 20px 20px">
    		<input id="imgSize1File" type="file" name="imgSize1File"  multiple >
    		<input id="input2" type="file" name="img" multiple class="cancelstyle"hidden="1">
            <input id="input3" type="file" name="img" multiple class="cancelstyle" hidden="0">
            <input id="input4" type="file" name="img" multiple class="cancelstyle" hidden="1">
    	</div>
    </div>
    <div class="mui-input-row" style="margin: 10px 10px 20px 20px  ;height:240px; border:1px solid #CCCCCC;" >
     <textarea class="mui-input-speech mui-input-clear" placeholder="丢了啥"></textarea>
    </div>
  
    <div class="mui-button-row">
        <button id="bnt" type="button" class="mui-btn mui-btn-primary" >确认</button>
        <input type="submit" value="提交" class="mui-btn-blue"/>
    </div>
</form>
	<script type="text/javascript">
	document.getElementById("imgSize1ImgSrc").onchange=function(){
		alert('111111111111');
	}
    function submitImgSize1Upload(){
	    alert('1111');
		var option={
				type:'POST',
				url:'${pageContext.request.contextPath }/upload/uploadPic.do',
				dataType:'text',
				data:{
					fileName :'imgSize1File',
				},
				success:function(data){
					
					//把json格式的字符串转换成json对象
					var jsonObj = $.parseJSON(data);
					//返回服务器图片路径，把图片路径设置给img标签
					$("#imgSize1ImgSrc").attr("src",jsonObj.fullPath);
					//数据库保存相对路径
					$("#imgSize1").val(jsonObj.relativePath);
					$("#imgSize1File").hide();					
				}
				
			}; 
			
		$("#itemForm").ajaxSubmit(option);
		
	}
      function submitImgSize1Upload2(){
	///alert($(this).val()+'11111');
		var option={
				type:'POST',
				url:'${pageContext.request.contextPath }/upload/uploadPic.do',
				dataType:'text',
				data:{
					fileName :'imgSize1File2',
				},
				success:function(data){
					
					//把json格式的字符串转换成json对象
					var jsonObj = $.parseJSON(data);
					 alert(jsonObj.fullPath);
					//返回服务器图片路径，把图片路径设置给img标签
					$("#imgSize1ImgSrc2").attr("src",jsonObj.fullPath);
					//数据库保存相对路径
					$("#imgSize12").val(jsonObj.relativePath);
					
				}			
		$("#itemForm").ajaxSubmit(option);
		
	}
		document.getElementById("btn").onclick=function(){
    		alert('22222');
    	}
</script>
	</body>

</html>