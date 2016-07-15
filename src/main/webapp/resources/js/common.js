/**
 * Created by yuxb on 16/6/28.
 */
var app = $.extend({}, app);
app.basePath = function() {
    var curWwwPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPaht = curWwwPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
};
app.config = function (name, value) {
    defaults[name] = value;
};
var ctx=app.basePath();
var defaults=app.defaults={
    pageParams:{pageNo:1,
                pageSize:25},
    width:800,
    height:500,
    ok:'ok',
    no:'no',
    yes:'yes',
    error:'error'
}
/**layPage分页插件默认配置**/
app.config.layPage={
    cont: 'grid_page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
    curr: 1,//当前页
    skip: true, //是否开启跳页
    skin: '#00AA91',
    first: '首页', //若不显示，设置false即可
    last: '尾页', //若不显示，设置false即可
    prev: '上一页', //若不显示，设置false即可
    next:  '下一页',
    contentId:'grid_content'
};

app.add=function(title,url,w,h){
    var w=defaults.width||w;
    var h=defaults.height||h;
    layer_show(title,ctx+'/'+url,w,h);
};
app.delete=function (obj,url,id) {
        layer.confirm('确认要删除吗？',function(index){
            //此处请求后台程序，下方是成功后的前台处理……
            $.ajax(url+'?ids='+id,function (res) {
               if(res.code==aa);
            });
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
};
app.edit=function (title,url,id,w,h){
    layer_show(title,url,w,h);

};

app.save=function (formId) {
    $('#'+fromId).submit({data:$('#'+formId).serialize()});
};
app.queryPage=function (config) {
    var layConfig=$.extend(app.config.layPage,config);
    var pageParams=$.extend(app.defaults.pageParams,config);
    pageParams.pageNo=layConfig.curr;
    $.getJSON(ctx+'/'+layConfig.url,pageParams, function (res) {
                laypage($.extend(layConfig,{
                    pages: res.pageCount,
                    jump: function (obj,first) {
                        if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                            config.curr=obj.curr;
                            app.queryPage(config);
                        }
                    }
                }));
            $('#'+layConfig.contentId).empty();
            $('#'+layConfig.contentId).html(app.parseData({list:res.data}));
        });
};

app.parseData=function(data) {
    return template('test', data);
};
