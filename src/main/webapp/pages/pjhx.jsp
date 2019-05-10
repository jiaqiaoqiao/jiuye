<%--
  Created by IntelliJ IDEA.
  Date: 2019/4/21
  User: 赵波波
  Time: 18:41
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
    var option = {
        title : {
            text: '世界人口总量',
            subtext: '数据来自网络'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['2011年', '2012年']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'value',
                boundaryGap : [0, 0.01]
            }
        ],
        yAxis : [
            {
                type : 'category',
                data : ['巴西','印尼','美国','印度','中国','世界人口(万)']
            }
        ],
        series : [
            {
                name:'2011年',
                type:'bar',
                data:[18203, 23489, 29034, 104970, 131744, 630230]
            },
            {
                name:'2012年',
                type:'bar',
                data:[19325, 23438, 31000, 121594, 134141, 681807]
            }
        ]
    };
    myChart.setOption(option);


</script>
</html>
