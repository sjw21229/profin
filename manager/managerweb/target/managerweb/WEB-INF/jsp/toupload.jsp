<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 19-1-9
  Time: 下午10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图床</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/weadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>

</head>
<body>
<textarea id="demo" style="display: none;"></textarea>
<script>
    layui.use('layedit',function(){
        //创建变量
        var layedit = layui.layedit;
        //初始化富文本编辑器
        //第二步：完成参数配置
        layedit.build('demo',{
            uploadImage:{
                url:'uploadImage',
                type:'post'
            }
        });
    });
</script>
</body>
</html>
