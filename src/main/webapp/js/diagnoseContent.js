$(document).ready(function () {
    var localObj = window.location;
    var basePath = localObj.protocol+"//"+localObj.host;
    var diagnoseId = $("#diagnoseId").text();

    layui.use('flow',function () {
        var flow = layui.flow;

        var editorflag = 0;
        diagnose_flow(diagnoseId);

        /*选项卡教师笔记加载bigin*/
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
                                    str += "<span>"+result.userId+"</span>";
                                } else if (diagnoseContent.role==="2"){
                                    str += "<span>"+result.doctorId+"</span>";
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
                    // stu_qa_flow("#stuQaall",basePath+"/stuQa/findStuQaList",parseInt($("#sectionId").text()));
                }
            });

        });
    });



});