<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/echarts.min.js"></script>
<script src="js/dark.js"></script>
</head>
<body>
	welcome
	<div id="main" style="width: 960px; height: 600px;"></div>
	<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'),'dark');
    // 指定图表的配置项和数据
    var option = {
        //标题
        title: {text: 'ECharts',left:150},
        //工具箱
        toolbox:{
        	show:true,
        	feature:{
        		dataView:{
        			show:true
        		},
        		restore:{
        			show:true
        		},
        		dataZoom:{
        			show:true
        		},
        		saveAsImage:{
        			show:true
        		},
        		magicType:{
        			type:['line','bar']
        		}
        	}
        	
        },
    	//弹窗
        tooltip: {
        	 trigger: 'axis'
        },
        //图例
        legend: {data:['销量']},
        //x轴
        xAxis: {data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]},

        yAxis: {},
        //数据:
        series: [{
            name: '销量',
            type: 'bar',//传一个数据
            data: [5, 20, 36, 10, 10, 20]//
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);//
</script>
</body>
</html>