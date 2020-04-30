$(document).ready(function () {
    var localObj = window.location;
    var basePath = localObj.protocol+"//"+localObj.host;
    var diagnoseId = $("#diagnoseId").text();

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
                // stu_qa_flow("#stuQaall",basePath+"/stuQa/findStuQaList",parseInt($("#sectionId").text()));
            }
        });

    });

});