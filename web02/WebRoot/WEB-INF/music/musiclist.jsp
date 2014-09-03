<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>音乐下载基地</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	th{
		background-color: #666666;
		color: #EEEEEE;
		height: 30px;
	}
	td{
		border-bottom: 1px solid #999999;
		height: 25px;
		text-align: center;
	}
	img{
		border: none;
	}
	a{
		color: #884455;
		text-decoration: none;
		point:hand;
	}
	a:HOVER {
		point:hand;
		text-decoration:none;
		color: #EE4455;
	}
</style>

  </head>
  
  <body>
  	<!-- 设置变量到 指定的 空间中 -->
  	<c:set value="曹操" var="aa" scope="page" ></c:set>
  	<c:set value="曹仁" var="aa" scope="request" ></c:set>
  	<c:set value="曹洪" var="aa" scope="session" ></c:set>
  	<c:set value="曹植" var="aa" scope="application" ></c:set>
  	
  	<c:remove var="aa" scope="page" />
    <h1>欢迎
    	<font style="color: #f00;">
    	<c:catch var="errMsg">
	    	<c:out value="${loginUser.loginNeme}" escapeXml="false"><font style="font-style: italic;"> 匿名登录</font>
	    	</c:out>
    	</c:catch>
    	</font>
    	来到音乐下载基地
    </h1>
  	<div style="position: static;height: 30px;">
  		<div style="float: left;">
		    <!-- 逻辑判断 -->
		    <c:if test="${loginUser.level==0}">铁牌会员</c:if>
		    <c:if test="${loginUser.level==1}">铜牌会员</c:if>
		    <c:if test="${loginUser.level==2}">银牌会员</c:if>
		    <!-- 复杂的 逻辑判断 -->	
		    <c:choose>
		    	<c:when test="${loginUser.level==0}">幼儿园</c:when>
		    	<c:when test="${loginUser.level==1}">小学生</c:when>
		    	<c:when test="${loginUser.level==2}">中学生</c:when>
		    	<c:otherwise>未入学</c:otherwise>
		    </c:choose>	
  		</div>
  		<div style="float: right;padding-right: 16px;">
  			<a href="#">
  			购物车物品种类： ${fn:length(items)}
  			</a>
  		</div>
    </div>
    	
    <hr/>
	<table width="100%" cellspacing="0">
		<tr>
			<th width="5%">编号</th>
			<th width="15%">歌曲名称</th>
			<th width="15%">作者</th>
			<th width="10%">类别</th>
			<th width="10%">费用</th>
			<th width="15%">下载路径</th>
			<th width="15%">创建日期</th>
			<th width="15%"></th>
		</tr>
		<!-- 判断 集合是否有数据 -->
		<c:choose>
			<c:when test="${fn:length(musics)>0}">
				<c:forEach items="${musics}" var="music" varStatus="status" >
					<tr <c:if test="${status.index%2==0}">style="background-color: #CCC;"</c:if>  >
						<td>${music.id}</td>
						<td>${music.musicName}</td>
						<td>${music.musicAuthro }</td>
						<td>${music.type }</td>
						<td>
							<fmt:formatNumber value="${music.money }" pattern="￥#0.00" ></fmt:formatNumber>
						</td>
						<td>${music.filePath }</td>
						<td>
							<fmt:formatDate value="${music.createDate }" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<c:if test="${loginUser!=null}">
								<a href="#" onclick="return change1(this)" >-</a>
								<input type="text" name="count" value="1" id="count" style="width: 20px;" />
								<a href="#" onclick="return change2(this)">+</a>
								<a href="auth/BuyItemServlet?itemId=${music.id}" onclick="return addItem(this)" title="加入购物车" rel="加入购物车">
								<img src="img/archive.png" style="width: 25px;height: 25px;" />
								</a>
							</c:if>
						</td>
					</tr>			
				</c:forEach>			
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">没有数据！</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<script type="text/javascript">
		function change1(tp){
			//当前数量
			var nStr=tp.parentNode.getElementsByTagName("INPUT")[0].value;
			if(nStr==null || nStr.length<1)
				nStr="0";
			var n=parseInt(nStr);
			n--;
			if(n<=0)
				n=0;
			tp.parentNode.getElementsByTagName("INPUT")[0].value=n;
			return false;
		}
		function change2(tp){
			//当前数量
			var nStr=tp.parentNode.getElementsByTagName("INPUT")[0].value;
			if(nStr==null || nStr.length<1)
				nStr="0";
			var n=parseInt(nStr);
			n=n+1;
			tp.parentNode.getElementsByTagName("INPUT")[0].value=n;
			//alert("增加数量到  "+n);
			
			return false;
		}
		function addItem(link){
			var url=link;
			var nStr=link.parentNode.getElementsByTagName("INPUT")[0].value;
			var n=parseInt(nStr);
			url+="&count="+n;
			link.getAttributeNode("href").value=url;
			return true;
		}
	</script>
	
	<div>
		<c:forTokens items="192.168.1.33" delims="." var="num">
			${num }<br/>
		</c:forTokens>
	
	</div>
	
	<%--<div style="height: 400px;position: static;border: 1px solid #C55;overflow: hidden;">
		<c:import url="http://www.baidu.com" charEncoding="UTF-8"></c:import>
	</div>
	--%>
	<div>
		<c:out value="${errMsg}"></c:out>
	</div>
	
  </body>
</html>
