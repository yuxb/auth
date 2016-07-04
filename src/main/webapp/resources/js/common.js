/**
 * Created by yuxb on 16/6/28.
 */
var app = $.extend({}, app);
app.load = function (url) {
    $("#page-wrapper").load(url,function (data) {
    });
};
app.openDialog = function (options) {
    $.post(options.url, options.data, function(str){
        var d = dialog({
            title: '欢迎',
            width:300,
            height:400,
            resize:true,
            ok:function(){
                
            },
            cancel:function () {
                
            },
            content: str
        });
        d.show();
    });

    
}


