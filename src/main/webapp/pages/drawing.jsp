<%--
  Created by IntelliJ IDEA.
  User: 赵波波
  Date: 2019/4/19
  Time: 18:33
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
        "../tubiao",
        function(data) {
         //查询部门和人数
            var  names=[];
            var values=[];
            for(var i = 0;i<data.length;i++){
                names[i]=data[i].name;
                values[i]=data[i].value;
            }
            var option = {
                title : {
                    text: '各个部门的名称和人数',
                    subtext: '',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient : 'vertical',
                    x : 'left',
                    data:names//部门
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                series : [
                    {
                        name:'访问来源',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data//键值对部门人数
                    }
                ]
            };
            myChart.setOption(option);

        });


</script>
</html>
