<%--
  Created by IntelliJ IDEA.
  User: Lycn
  Date: 2019/4/13
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" >
<script src="js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="../js/css.css" type="text/css"></link>
<head>
    <title>Title</title>
</head>
<script>
    function tubiao(){
        location.href="tubiao.do";
    }
    $(function(){
       $.post(
           "countryList",[],
           function(obj){
               for(var i in obj){
                   $("#country").append("<option value='"+obj[i].countryId+"'>"+obj[i].countryName+"</option>");
               }
           }
       );
    });
    function locaS(){
        $("#loca"). empty();
        $("#department"). empty();
        var coutryId = $("#country").val();
        $.post(
            "locaList",
            {coutryId:coutryId},
            function(obj){
                for(var i in obj){
                    $("#loca").append("<option value='"+obj[i].locationId+"'>"+obj[i].streetAddress+"</option>");
                }
                $("#loca").val("${e.streetAddress}");
            }
        );
    }
    function departS(){
        $("#department"). empty();
        var locaId = $("#loca").val();
        $.post(
            "departmentList",
            {locaId:locaId},
            function(obj){
                for(var i in obj){
                    $("#department").append("<option value='"+obj[i].departmentId+"'>"+obj[i].departmentName+"</option>");
                }
                $("#department").val("${e.departmentName}");
            }
        );
    }
</script>
<body>
    <table>
        <tr>
            <td colspan="99">
                <form action="list" method="post">
                    <table>
                        <tr>
                            <td>员工名字:<input type="text" name="employeeName"></td>
                        </tr>
                        <tr>
                            <td>
                                国家:<select  id="country" onchange="locaS()">

                            </select><br>
                                地址:<select  id="loca" onchange="departS()">

                            </select><br>
                                部门:<select name="departmentId" id="department">

                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                入职日期:<input type="date" name="startDate">至
                                <input type="date" name="endDate">
                            </td>
                        </tr>
                         <tr>
                             <td>
                                 薪资:<select name="compareS">

                                         <option value="2">大于</option>
                                         <option value="1">等于</option>
                                         <option value="0">小于</option>
                                    </select>
                                 <input type="text" name="salary">
                             </td>
                         </tr>
                        <tr>
                            <td><input type="submit" value="搜索"></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
        <tr>
            <td>序号</td>
            <td>部门</td>
            <td>员工名称</td>
            <td>邮箱</td>
            <td>电话号码</td>
            <td>入职日期</td>
            <td>薪资</td>
            <td>办公地址</td>
            <td>所属国家</td>
            <td><a href="add()">添加</a>||<<input type="button" onclick="tubiao()" value="图表"></td>
        </tr>
        <c:forEach items="${employeeList}" var="e">
            <tr>
                <td>${e.employeeId}</td>
                <td>${e.departmentName}</td>
                <td>${e.name}</td>
                <td>${e.email}</td>
                <td>${e.phoneNumber}</td>
                <td>${e.hireDate}</td>
                <td>${e.salary}</td>
                <td>${e.streetAddress}</td>
                <td>${e.countryName}</td>
                <td><a href="update.do?id=${e.employeeId}">修改</a>||<a href="del.do?id=${e.employeeId}">删除</a></td>


            </tr>
        </c:forEach>
        <%--<tr>
            <td colspan="99">${page.pageStr}</td>
        </tr>--%>
    </table>
</body>
</html>
