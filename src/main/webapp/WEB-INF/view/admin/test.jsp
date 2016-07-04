<%--
  Created by IntelliJ IDEA.
  User: yuxb
  Date: 16/6/13
  Time: 上午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/plug-in/jquery/jquery-1.8.0.min.js"></script>
    <script language="JavaScript">

        function submit1() {

            var page = new Object();
            page.pageNo = 1;
            page.pageSize = 13;

            // var customerArray = '"page":{"pageNo":1,"pageSize":1},"organization":{"name":"dddf":"code":"fff"}';
            $.ajax({
                url: "/org/orgs/",
                type: "get",
                contentType: 'application/json;charset=utf-8', //设置请求头信息
                dataType: "json",
                //data: JSON.stringify(customerArray),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
                data: $("#form").serialize(),            //将Json对象序列化成Json字符串，toJSON()需要引用jquery.json.min.js
                success: function (data) {
                    alert(data);
                },
                error: function (res) {
                    alert(res.responseText);
                }
            });
        }
    </script>
</head>
<body>
<form id="form">

    <p> <input name="pageSize" type="text">
    <input name="pageNo" type="text">
    </p>
<p> <input type="text" name="queryFieldList[0].key">
<input type="text" name="queryFieldList[0].value">
    <input type="text" name="queryFieldList[0].type">
</p>
    <p> <input type="text" name="queryFieldList[1].key">
        <input type="text" name="queryFieldList[1].value">
        <input type="text" name="queryFieldList[1].type">
        <input type="button" value="提交" onclick="javascript:submit1()">
    </p>
</form>
</body>
</html>
