<%@ page contentType="text/html;charset=UTF-8"%>
<div class="row">
    <div class="col-lg-12">
        <ol class="breadcrumb">
            <li><a href="#" onclick="app.load('/auth/res/list')"><i class="fa fa-dashboard"></i>菜单管理</a></li>
        </ol>
    </div>
</div>
<div class="row margin-bottom-5">
    <div class="col-lg-12 btn-group-sm" >
        <button type="button" class="btn btn-primary" onclick="app.openDialog({url:'/auth/load/admin/res/add'});">新增</button>
        <button type="button" class="btn btn-success">修改</button>
        <button type="button" class="btn btn-danger">删除</button>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <table id="gridTable"></table>
        <div id="gridPager"></div>
    </div>
</div>
<script>
    $(function()
    {
        $("#gridTable").jqGrid({
            width:'100%',
            datatype: "local",
            colNames:['编号','用户名', '性别', '邮箱', 'QQ','手机号','出生日期'],
            colModel:[
                {name:'id',index:'id', width:60, sorttype:"string"},
                {name:'userName',index:'userName', width:90},
                {name:'gender',index:'gender', width:90},
                {name:'email',index:'email', width:125,sorttype:"string"},
                {name:'QQ',index:'QQ', width:100},
                {name:'mobilePhone',index:'mobilePhone', width:120},
                {name:'birthday',index:'birthday', width:100, sorttype:"date"}
            ],
            sortname:'id',
            sortorder:'asc',
            viewrecords:true,
            rowNum:2,
            styleUI : 'Bootstrap',
            rowList:[10,20,30],
            pager:"#gridPager",
        });
        var mydata = [
            {id:"1",userName:"polaris",gender:"男",email:"fef@163.com",QQ:"33334444",mobilePhone:"13223423424",birthday:"1985-10-01"},
            {id:"2",userName:"李四",gender:"女",email:"faf@gmail.com",QQ:"222222222",mobilePhone:"13223423",birthday:"1986-07-01"},
            {id:"3",userName:"王五",gender:"男",email:"fae@163.com",QQ:"99999999",mobilePhone:"1322342342",birthday:"1985-10-01"},
            {id:"4",userName:"马六",gender:"女",email:"aaaa@gmail.com",QQ:"23333333",mobilePhone:"132234662",birthday:"1987-05-01"},
            {id:"5",userName:"赵钱",gender:"男",email:"4fja@gmail.com",QQ:"22222222",mobilePhone:"1343434662",birthday:"1982-10-01"},
            {id:"6",userName:"小毛",gender:"男",email:"ahfi@yahoo.com",QQ:"4333333",mobilePhone:"1328884662",birthday:"1987-12-01"},
            {id:"7",userName:"小李",gender:"女",email:"note@sina.com",QQ:"21122323",mobilePhone:"13220046620",birthday:"1985-10-01"},
            {id:"8",userName:"小三",gender:"男",email:"oefh@sohu.com",QQ:"242424366",mobilePhone:"1327734662",birthday:"1988-12-01"},
            {id:"9",userName:"孙先",gender:"男",email:"76454533@qq.com",QQ:"76454533",mobilePhone:"132290062",birthday:"1989-11-21"}
        ];
        for(var i=0;i<=mydata.length;i++)
            jQuery("#gridTable").jqGrid('addRowData',i+1,mydata[i]);
    });

    function appOpen() {
        layer.alert('内容');
        //artDialog.open();
        //art.dialog.open('authl/load/admin/res/add');
    }
</script>