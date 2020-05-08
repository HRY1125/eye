<%--
  Created by IntelliJ IDEA.
  User: wz
  Date: 2019/11/18
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>诊断信息</title>
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="/layui/layui.js" charset="utf-8"></script>
    <style>
        .diagnoseTest{
            font-size: 40px;
        }
    </style>
</head>
<body>
    <ul class="flow-default" id="diagnoseUL"></ul>
    <script>
        layui.use('flow', function(){
            var flow = layui.flow;

            flow.load({
                elem: '#diagnoseUL' //流加载容器
                ,isAuto: false
                ,isLazyimg: true
                ,done: function(page, next){ //加载下一页
                    //模拟插入
                    setTimeout(function(){
                        var lis = [];
                        var limit = 5;//刚开始要显示的诊断数
                        var number;
                        var data = {"page":page,"limit":limit};
                        $.ajax({
                            type : "POST",
                            url :"/diagnosefront/queryAllByDiagnose",
                            data: data,
                            success: function (data) {
                                console.log(data);
                                number=data.number;
                                layui.each(data.diagnoseList, function (index, courses) {
                                    /*console.log(index);
                                    console.log(courses);*/
                                    lis.push('<li class="diagnoseTest"><input type="hidden" value="'+courses.diagnoseId+'"><center>'+courses.title+'</center></li>');
                                    /*lis.push(((page-1)*6 + i + 1 ));
                                    lis.push();
                                    lis.push('</li>');*/
                                });
                                next(lis.join(''), page < number); //假设总页数为 6
                            }
                        });

                    }, 500);
                }
            });
        });
        $("#diagnoseUL").on("click",".diagnoseTest", function(){
            //alert($(this).children().first().val());
            var diagnoseId = $(this).children().first().val()//获取当前诊断信息的id
            $.ajax({
                type: "POST",
                url: "/eye/exercisetime",
                async: false,
                data: {},
                success: function (msg) {
                    window.location.href = '/eye/exercisetime';
                }
            });
        });
    </script>
</body>
</html>