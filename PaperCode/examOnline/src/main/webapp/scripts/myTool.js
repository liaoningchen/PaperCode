//时间戳转为时间格式函数
$.extend({
	timestampToTime:function(timestamp){
		var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        h = date.getHours() + ':';
        m = date.getMinutes() + ':';
        s = date.getSeconds();
        return Y+M+D+h+m+s;
	}
});
//字符串转为json数据工具类
$.extend({
	strToJson:function(str){
		return JSON.parse(str);
	}
});
//json数据转为字符串
$.extend({
	jsonToStr:function(json){
		return JSON.stringify(json);
	}
});
//Json操作
$.extend({
	upJson:function(json,key,value){
		// 如果 val 被忽略
	    if(typeof value === "undefined") {
	        // 删除属性
	        delete json[key];
	    }
	    else {
	        // 添加 或 修改
	        json[key] = value;
	    }
	}
});
//设置cookie值
$.extend({
	setCookie:function(cname,cvalue,exdays){
		var d = new Date();
	    d.setTime(d.getTime() + (exdays*24*60*60*1000));
	    var expires = "expires=" + d.toGMTString()  ;
	    /*path解决页面跳转cookie失效问题*/
	    document.cookie = cname + "=" + cvalue + ";" + expires+ ";path=/";
	}
});
//读取cookie值
$.extend({
	getCookie:function(cname){
		var name = cname + "=";
	    var value = document.cookie.split(";");
	    for(var i=0;i<value.length;i++){
	        var c = value[i];
	        while(c.charAt(0)==' '){
	            c = c.substring(1); 
	        }
	        if(c.indexOf(cname) == 0){
	            return c.substring(name.length,c.length);
	        }
	    }
	    return "";
	}
});

/**
* 获得请求参数的jquery全局插件
*/
$.extend({
	getParam:function(key) {

		var url = decodeURI(location.href); //获得当前url地址

		var index = url.indexOf('?');//返回？的位置

		var str = url.substring(index + 1); //截取？后面的内容

		var arr= str.split('&'); //按照&分解字符串为数组

		//遍历数组
		for (var i = 0;i < arr.length;i ++) {

			//根据=分解字符串
			var param = arr[i].split('=');

			//如果传入的参数名和当前名称相等，返回参数值
			if (param[0] == key) {
				return param[1];
			}

		}

	}	
});
//添加或者修改json数据
$.extend({
	setJson:function(jsonStr, name, value){

	    if (!jsonStr){
	    	 jsonStr = '{"json":{}}';
	    }
	    var jsonObj = JSON.parse(jsonStr);
	    jsonObj.json[name] = value;
	    return JSON.stringify(jsonObj);
	}
});
//删除json数据
$.extend({
	delJson:function(jsonStr, name){
		if (!jsonStr){
			 return null;
		}
	    var jsonObj = JSON.parse(jsonStr);
	    delete jsonObj[name];
	    return JSON.stringify(jsonObj);
	}
});
/*json测试*/
/*////生成测试
var myjsonStr = setJson(null,"name","aaa");
alert(myjsonStr);
////添加测试
 myjsonStr = setJson(myjsonStr,"age",18);
 alert(myjsonStr);
////修改测试
// myjsonStr = setJson(myjsonStr,"age",20);
// alert(myjsonStr);
////删除测试
// myjsonStr = deleteJson(myjsonStr,"age");
// alert(myjsonStr);
*/