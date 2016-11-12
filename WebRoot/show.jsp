<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>数据显示</title>
</head>
<style>
    header h1 {
        font-weight:normal;
        padding: 30px;
        text-align: center;
        color:#00aaec;
        
    }
    #main {
        margin:20px auto;
        width:1200px;
        margin-bottom:50px;
    }
    #main1 {
        border:1px solid red;
        width:70%;
        float:left;
        margin-bottom:50px;
    }
    #main2 {
        width:25%;
        height:400px;
        float:left;
        margin-left:20px; 
    }
    #main2 h3 {
        font-weight: normal;
        font-size: 26px;
        color : #0aaeca;
        text-align: center;
        margin: 20px 0;
    }
    #main2 p {
        margin:20px;
        font-size:18px;
       
        margin-left:50px;
    }
    #main2 p span {
        color:red;
        font-size:20px;
        font-weight:bold;
    }
    #main2 p strong {
        font-size:14px;
    }
    #footer {
        clear:both;
        position: relative;
        bottom: 0;
        text-align:center;
        margin-top: 50px;
    }
    
</style>
<body>
    <header>
        <h1>蜗牛家居助手</h1>
    </header>
    <div id="main">
        <div id="main1" style="height:400px;"></div>
        <div id="main2">
            <h3>当前值：</h3>
            <p>温度值：<span  id="temperature">23.5</span><strong> &#8451;</strong></p>
            <p>湿度值：<span id="humidity">55.5</span> <strong>%RH</strong></p>
            <div class="panel panel-primary tips">
                <div class="panel-heading">
                   温馨提示：
                   <span class="glyphicon glyphicon-hand-down"></span>
                </div>
                <div class="panel-body">
                    <p>昼夜温差15  &#8451;，请适时增减衣物！</p>
                    <p>气候干燥，请多补充水分！</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="footer">
        <div class="footer_inner">
            <p>Copyright © 2016.</p>
        </div>
    </div>
    </div>
    <!-- ECharts单文件引入 -->
     <script src="js/echarts.js"></script>
    <!-- 引入 vintage 主题 -->
    <script src="js/vintage.js"></script>
    <script type="text/javascript">
    function HideDiv(){
        $("#main1").hide();
    }
    function ShowDiv(){
        $("#main1").show();
    }
    $("#mytab a").click(function(e){
        e.preventDefault();
        $(this).tab("show");
    });
    var dataArr = new Array();
    var dataObj1 = [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3];
    var dataObj2 = [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3];
    // 使用
    var myChart =echarts.init(document.getElementById('main1'),'vintage'); 
 	var b=[];
   	var c=[];
    setInterval(function(){
     $.ajax({
    	url:"http://localhost:8080/Test/servlet/sendservlet?flag=temp",
    	type:"get",
    	success:function(data){
    		var a = data;
    		//console.log(b.length);
    		//数组数据替换
  
    		$("#temperature").html(a);
 			b.push(a);
    		}
    	});
    		dataArr.push(c);
    		dataArr.push(b);
    		console.log(dataArr.length);
    		doit();
    },2000);
    	
    	 setInterval(function(){
     $.ajax({
    	url:"http://localhost:8080/Test/servlet/sendservlet?flag=humi",
    	type:"get",
    	success:function(data){
    		var a = data;
    		
    		$("#temperature").html(a);
    		c.push(a);
    		//console.log(b.length);
    		//数组数据替换
    		
 
    		}
    	});
    	
    
    		dataArr.push(c);
    		dataArr.push(b);
    		console.log(dataArr.length);
    		doit();
    },2000);
    	
    	
               function doit(){  myChart.setOption(option = {
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
                            mark : {show: true},//辅助线开关
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar','radar','pie']},//类型是否转换？折线和柱形互转
                            restore : {show: true},//还原
                            saveAsImage : {show: true}//保存为图片
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            data : ['1:00','2:00','3:00','4:00','5:00','6:00','7:00','8:00','9:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00','21:00','22:00','23:00','24:00'
                            ,'1:00','2:00','3:00','4:00','5:00']
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'湿度',
                            type:'line',
                            data:dataArr[1],
                            markPoint : {
                                data : [
                                    {type : 'max', name: '周最高'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        },
                        {
                            name:'温度',
                            type:'line',
                            data:dataArr[0],
                            markPoint : {
                                data : [
                                    {type : 'max', name: '周最高'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name : '平均值'}
                                ]
                            }
                        }
                    ]
            

             
            }
    );
    }
</script>


</body>
</html>
