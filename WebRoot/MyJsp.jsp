<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-2.0.3.js"></script>
    <title>My JSP 'MyJsp.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
    <div id="temp"></div>
    
    <script src="js/echarts.js"></script>
    <!-- 引入 vintage 主题 -->
    <script src="js/vintage.js"></script>
    <script type="text/javascript">
    
      //documrnt.getElenmentById("temp").innerHTML = serchData.get
     // 路径配置
    
         
                // 基于准备好的dom，初始化echarts图表
                var myChart =echarts.init(document.getElementById('main'),'vintage'); 
                var dataArr = new Array();
    var dataObj1 = [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6];
    var dataObj2 = [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6];
    var b=[];
   
    setInterval(function(){
     $.ajax({
    	url:"http://localhost:8080/Test/servlet/sendservlet?flag=temp",
    	type:"get",
    	success:function(data){
    		var a = data;
    
    		b.push(a);
    		//console.log(b.length);
    		//数组数据替换
    		
 
    		}
    	});
    	
    dataArr.push(dataObj1);
    		dataArr.push(dataObj2);
    		dataArr.push(b);
    		console.log(dataArr.length);
    		doit();
    },1000);
   
  
    
   
    
    
    dataArr.push(dataObj1);
    		dataArr.push(dataObj2);
    		dataArr.push(b);
    		console.log(dataArr.length);
    		doit();
    
    function doit(){
    	 myChart.setOption(option = {
    title : {
        text: '室内温湿度变化情况',
        subtext: ''
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['温度','湿度']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['周一','周二','周三','周四','周五','周六','8']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'成交',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:dataArr[2]
        },
        {
            name:'预购',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:dataArr[1]
        }
       
    ]
}
                 );  
    }
                              
        
                // 为echarts对象加载数据 
                // myChart.setOption(option); 
            
     
    </script>
  </body>
</html>
