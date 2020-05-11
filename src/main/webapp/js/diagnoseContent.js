$(document).ready(function () {
    var localObj = window.location;
    var basePath = localObj.protocol+"//"+localObj.host;
    var diagnoseId = $("#diagnoseId").text();



    layui.use('flow',function () {
        var flow = layui.flow;

        var editorflag = 0;
        diagnose_flow(diagnoseId);

        /*加载图表*/
        getLineChart(diagnoseId);
        getBarChart(diagnoseId);
        getPieChart(diagnoseId);

        function format(date){
            var date1= new Date(Date.parse(date));
            var year = date1.getFullYear();
            var month = date1.getMonth()+1;
            var day = date1.getDate();

            return year+"-"+month+"-"+day;
        }


        function getLineChart(diagnoseId) {
            var eyeTimes = [];//眼保健操时间
            var wangyuanTimes = [];//望远运动时间
            var yunyanTimes = [];//熨眼法时间
            var xiyanTimes = [];//洗眼法时间
            var dates  = [];//日期
            $.ajax({
                type: "POST",
                url: basePath+"/dContent/selectTimes",
                dataType: "json",
                data: {"diagnoseId": diagnoseId},
                success: function (result) {
                    var eyeList = result.eyeList;
                    for (var i =eyeList.length-1;i>=0;i--){
                        var eye = eyeList[i];
                        eyeTimes.push(eye.eyeTime);
                        wangyuanTimes.push(eye.wangyuanTime);
                        yunyanTimes.push(eye.yunyanTime);
                        xiyanTimes.push(eye.xiyanTime);
                        dates.push(format(eye.date));
                    }
                    // $.each(result.eyeList,function (i, eye) {
                    //     eyeTimes.push(eye.eyeTime);
                    //     wangyuanTimes.push(eye.wangyuanTime);
                    //     yunyanTimes.push(eye.yunyanTime);
                    //     xiyanTimes.push(eye.xiyanTime);
                    //     dates.push(format(eye.date));
                    // });
                    // 指定图表的配置项和数据
                    var option = {
                        title : {
                            text: "眼部保健时间折线图"
                        },
                        tooltip : { },
                        legend: {
                            data:['眼保健操时间','望远运动时间','熨眼法时间','洗眼法时间'],
                            right:"5%"
                        },
                        xAxis:{
                            name: '日期',
                            type: 'category',
                            boundaryGap: false,
                            data : dates
                        },
                        yAxis:{
                            name: '时间',
                            type: 'value'
                        },
                        series: [
                            {
                                name: '眼保健操时间',
                                type: 'line',
                                symbol: 'emptycircle',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
                                data: eyeTimes
                            },
                            {
                                name: '望远运动时间',
                                type: 'line',
                                symbol: "emptycircle",
                                data: wangyuanTimes
                            },
                            {
                                name: '熨眼法时间',
                                type: 'line',
                                symbol: "emptycircle",
                                data: yunyanTimes
                            },
                            {
                                name: '洗眼法时间',
                                type: 'line',
                                symbol: "emptycircle",
                                data: xiyanTimes
                            }
                        ]
                    };

                    var lineChart = echarts.init(document.getElementById('line_chart'));
                    lineChart.setOption(option);
                }
            })
        }
        function getBarChart(diagnoseId) {
            $.ajax({
                type: "POST",
                url: basePath+"/dContent/selectEyeByIdAndDate",
                dataType: "json",
                data: {"diagnoseId": diagnoseId},
                success: function (result) {
                    var eye = result.eye;
                    // 指定图表的配置项和数据
                    var option = {
                        title : {
                            text: "眼部保健时间柱形图"
                        },
                        tooltip : { },
                        legend: {
                            data:['时间'],
                            right:"5%"
                        },
                        xAxis:{
                            position: 'bottom',
                            data : ["眼保健操","望远运动","熨眼法","洗眼法"]
                        },
                        yAxis:{
                            position: 'left',
                            type: 'value'
                        },
                        series: [
                            {
                                name: '时间',
                                type: 'bar',
                                data: [eye.eyeTime/4,eye.wangyuanTime/4,eye.yunyanTime/4,eye.xiyanTime/4],
                                itemStyle:{					//---图形形状
                                    color:'blue'
                                },
                                barWidth:'40',
                                barCategoryGap:'2%'
                            }
                        ]
                    };

                    var barChart = echarts.init(document.getElementById('bar_chart'));
                    barChart.setOption(option);
                }
            })
        }
        function getPieChart(diagnoseId) {
            $.ajax({
                type: "POST",
                url: basePath+"/dContent/selectEyeByIdAndDate",
                dataType: "json",
                data: {"diagnoseId": diagnoseId},
                success: function (result) {
                    var eye = result.eye;
                    // 指定图表的配置项和数据
                    var option = {
                        title : {
                            text: "眼部保健时间扇形图",
                            x: "center"
                        },
                        tooltip : {
                            ttigger: 'item',
                            // formatter设置提示框显示内容
                            // {a}指series.name  {b}指series.data的name
                            // {c}指series.data的value  {d}%指这一部分占总数的百分比
                            formatter: "{a} <br/>{b} : {c}({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            x: 'left',
                            y: 'bottom',
                            textStyle: {
                                color: '#adadad'  // 图例文字颜色
                            },
                            itemGap: 10,//图例间隔
                            data : ["眼保健操","望远运动","熨眼法","洗眼法"]
                        },
                        // calculable : true,
                        series: [
                            {
                                name: '时间',
                                type: 'pie',
                                radius: '65%',// 设置环形饼状图， 第一个百分数设置内圈大小，第二个百分数设置外圈大小 一个值时为实心圆
                                center: ['50%','60%'], // 设置饼状图位置，第一个百分数调水平位置，第二个百分数调垂直位置
                                hoverAnimation:false,//鼠标悬浮突出功能停止
                                data: [
                                    {value :eye.eyeTime,name:'眼保健操'},
                                    {value :eye.wangyuanTime,name:'望远运动'},
                                    {value :eye.yunyanTime,name:'熨眼法'},
                                    {value :eye.xiyanTime,name:'洗眼法'}],
                                label: {
                                    normal: {
                                        position: 'outer',
                                        formatter: '{b} \n ({d}%)'
                                    },
                                    rich: {
                                        b: {
                                            align: 'center'
                                        }
                                    }
                                }
                            }
                        ]
                    };

                    var pieChart = echarts.init(document.getElementById('pie_chart'));
                    pieChart.setOption(option);
                }
            })
        }
        /*诊断内容流加载*/
        function diagnose_flow(diagnoseId) {
            $("#diagnoseContent").empty();
            flow.load({
                elem: '#diagnoseContent',//流加载容器
                isAuto: false,
                done: function (page, next) { //加载下一页
                    var lis = [];
                    var limit = 10;
                    var data = {"diagnoseId": diagnoseId, "page": page, "limit": limit};
                    $.ajax({
                        type: "POST",
                        url: basePath+"/dContent/selectDContent",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            var str = "";
                            layui.each(result.diagnoseContents, function (i, diagnoseContent) {
                                editorflag++;
                                str += "<div class=\"diagnose_box\">";
                                str += "<div class=\"diagnose_answer\">";
                                if (diagnoseContent.role === "1"){
                                    str += "<div class='answer'>";
                                    str += "<span>用户</span>";
                                    str += "<span>"+result.userName+"</span>";
                                    str += "</div>";
                                } else if (diagnoseContent.role==="2"){
                                    str += "<div class='answer'>";
                                    str += "<span>医生</span>";
                                    str += "<span>"+result.doctorName+"</span>";
                                    str += "</div>";
                                }
                                str += "</div>";
                                str += "<div class=\"diagnose_content\">";
                                str += "<div class=\"diagnose-toolbar\" id='diagnose-toolbar"+editorflag+"'></div>";
                                str += "<div class=\"diagnose-textEditor\" id='diagnose-textEditor"+editorflag+"'>"+diagnoseContent.content+"</div>";
                                str += "</div>";
                                editorCreate(editorflag);
                                str += "</div>";
                            });
                            lis.push(str);
                            next(lis.join(''), page < result.pages);
                        }
                    })
                }
            })
        }

        /*富文本编辑器生成*/
        function editorCreate(editorflag) {
            var E = window.wangEditor;
            var editor = "editor" + editorflag;
            console.log(editor);
            editor = new E('#diagnose-toolbar'+editorflag, '#diagnose-textEditor'+editorflag);
            editor.create();
        }


        /*富文本编辑器生成*/
        var E = window.wangEditor;
        // var editor = new E('#toolbar_div', '#text_div');
        var editor = new E('#editor');
        editor.customConfig.menus = [
            'bold',  // 粗体
            'fontSize',  // 字号
            'fontName',  // 字体
            'italic',  // 斜体
            'underline',  // 下划线
            'strikeThrough',  // 删除线
            'foreColor',  // 文字颜色
            'backColor',  // 背景颜色
            'link',  // 插入链接
            'list',  // 列表
            'justify',  // 对齐方式
            'quote',  // 引用
            'emoticon',  // 表情
            'table',  // 表格
            'undo',  // 撤销
            'redo'  // 重复
        ];
        editor.create();
        console.log(diagnoseId);

        /*回复提交按钮点击提交事件*/
        $(document).on("click", "#btn_submit", function () {

            var content = editor.txt.html();
            var data = {"content":content,"diagnoseId":diagnoseId};
            $.ajax({
                type:"POST",
                url:basePath+"/dContent/insertDContent",
                data:data,
                dataType: "json",
                traditional:true,
                success:function (result) {
                    editor.txt.clear();
                    diagnose_flow(diagnoseId);
                }
            });

        });
    });



});