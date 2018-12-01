// 后端访问地址前缀
var baseUrl = "http://127.0.0.1:8080/examOnline";
/*var baseUrl = "http://39.104.50.122:8080/examOnline";*/
//插入学生信息
var  STUDENTINSERT = "/student/insert";
//用户登录
var  LOGIN = "/student/login";
//用户密码修改
var MODIFPASS = "/student/modifpass";
//修改密码是验证码发送
var SENDNUMTOEMAIL = "/student/sendnumtoemail";
//上一题 下一题
var SELECTPRACTICE = "/student/selectPractice";
//指定某一体
var CHOOOSE = "/student/choose";
//左侧导航栏
var LEFTBAR = "/student/leftbar";
//获得练习题个数
var GETCOUNT = "/student/getCount";
//获得试题
var GETEXAMQUES = "/student/getExamQues";
//保存学生答案
var  SAVEDATA = "/student/saveData";
//获得学生成绩
var  GETSCORE = "/student/getScore";
//获得学生试卷
var GETPAPER = "/student/getPaper";
//全局的ajax访问，处理ajax清求时session超时  
$.ajaxSetup({   
    complete: function(xhr, textStatus) {
        //通过XMLHttpRequest取得响应头，sessionstatus，  
        var sessionstatus = xhr.getResponseHeader("sessionStatus"); 

        if (sessionstatus == "timeout") {
            alert('session超时，请重新登录');
            //如果超时就处理 ，指定要跳转的页面  
            location.href = 'logout.html';
        }
    }
});