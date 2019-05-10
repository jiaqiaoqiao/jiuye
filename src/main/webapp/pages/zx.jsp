<%--
  Created by IntelliJ IDEA.
  User: 赵波波
  Date: 2019/4/20
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-1.9.1.min.js"></script>
<script src="/js/echarts-all.js" ></script>
<body>
<div id="main" style=" width: 1000px;height: 500px">
</div>
</body>
<script>
    var myChart = echarts.init(document.getElementById('main'));
    $.post(
        "../zui",
        function(data){

            var a=data.name;
            var x=data.x;
            var y=data.y;
            var z=data.z;

            var option = {
                title : {
                    text: '最高 最低 平均',
                    subtext: '工资'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['最高工资','最低工资','平均工资']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : a
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'最高工资',
                        type:'bar',
                        data:x
                    },
                    {
                        name:'最低工资',
                        type:'bar',
                        data:y
                    },
                    {
                        name:'平均工资',
                        type:'bar',
                        data:z
                    }
                ]
            };
            myChart.setOption(option);
        });


</script>
</html>
