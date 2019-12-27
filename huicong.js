var page = require('webpage').create(),
	system = require('system'),
	t, address;
//写入文件，用来测试。正式版本可以注释掉用来提高速度。
var fs = require("fs");
//读取命令行参数，也就是js文件路径。
if(system.args.length === 1) {
	console.log('Usage: loadspeed.js <some URL>');
	//这行代码很重要。凡是结束必须调用。否则phantomjs不会停止
	phantom.exit();
}
page.settings.loadImages = false; //为了提升加载速度，不加载图片
page.settings.resourceTimeout = 10000; //超过10秒放弃加载
//此处是用来设置截图的参数。不截图没啥用
page.viewportSize = {
	width: 1280,
	height: 800
};
block_urls = ['baidu.com']; //为了提升速度，屏蔽一些需要时间长的。比如百度广告
page.onResourceRequested = function(requestData, request) {
	for(url in block_urls) {
		if(requestData.url.indexOf(block_urls[url]) !== -1) {
			request.abort();
			//console.log(requestData.url + " aborted");
			return;
		}
	}
}
	/*
var flag = phantom.addCookie({
	
	"Cookie":"
	login_sid_t = 4 cf727ad071b41296f443d951221b401;
cross_origin_proto = SSL;
_s_tentry = passport.weibo.com;
Apache = 6563767398768.017 .1576732291495;
SINAGLOBAL = 6563767398768.017 .1576732291495;
ULV = 1576732291507: 1: 1: 1: 6563767398768.017 .1576732291495: ;
UOR = , , login.sina.com.cn;
appkey = ;
YF - Page - G0 = aac25801fada32565f5c5e59c7bd227b | 1576825534 | 1576825333;
SUB = _2A25w - AcxDeRhGeFO6lYX8SrMzDyIHXVTjH_5rDV8PUNbmtANLRjekW9NQZME_5EUPahiL9og1DDjyL9FnBoNPqsc;
SUBP = 0033 WrSXqPxfM725Ws9jqgMF55529P9D9W5Eo9jDMJ0cuHTxChY.axgf5JpX5KzhUgL.FoM7eKBceKB7S052dJLoI0qLxK - L1K5LB - qLxKqL1KnL12 - LxKqL1KnL1 - qLxKML1 - 2 L1hBLxK - LBKBL1 - eLxKqL1K.L1 - 2 t;
SUHB = 0x nCEMUlFtJQFc;
ALF = 1608362721;
SSOLoginState = 1576826721;
wb_view_log_7014614070 = 1366 * 7681 % 261920 * 10801;
TC - Page - G0 = 45685168 db6903150ce64a1b7437dbbb | 1576827979 | 1576827979;
webim_unReadCount = % 7 B % 22 time % 22 % 3 A1576828116823 % 2 C % 22 dm_pub_total % 22 % 3 A0 % 2 C % 22 chat_group_client % 22 % 3 A1007 % 2 C % 22 allcountNum % 22 % 3 A1007 % 2 C % 22 msgbox % 22 % 3 A0 % 7 D
	"

	"name":"SUHB",
	"value":"0 V5lqAh0nIbEK_",
	"path":"/",
	"login_sid_t"="4 cf727ad071b41296f443d951221b401",
	"cross_origin_proto" : "SSL",
	"_s_tentry" :" passport.weibo.com",
	"Apache" :"6563767398768.017 .1576732291495",
	"SINAGLOBAL" : "6563767398768.017 .1576732291495",
	"ULV" : "1576732291507: 1: 1: 1: 6563767398768.017 .1576732291495: ",
	"UOR" : ",,login.sina.com.cn",
	"appkey" :null ,
	"SUB" : "_2A25w_wePDeRhGeFO6lYX8SrMzDyIHXVTjX5HrDV8PUNbmtANLW3CkW9NQZME_2SLoqNuuESc6t9c72pj6CH5ea0N",
	"SUBP" : "0033 WrSXqPxfM725Ws9jqgMF55529P9D9W5Eo9jDMJ0cuHTxChY.axgf5JpX5KzhUgL.FoM7eKBceKB7S052dJLoI0qLxK - L1K5LB - qLxKqL1KnL12 - LxKqL1KnL1 - qLxKML1 - 2 L1hBLxK - LBKBL1 - eLxKqL1K.L1 - 2 t",
	"SUHB" : "0 V5lqAh0nIbEK_",
	"ALF" : "1608297311",
	"SSOLoginState" : "1576761311",
	"wvr" : "6",
	"wb_view_log_7014614070" : "1366 * 7681",
	"TC - Page - G0" : "b993e9b6e353749ed3459e1837a0ae89 | 1576812681 | 1576812647",
	"webim_unReadCount" : "% 7 B % 22 time % 22 % 3 A1576820058712 % 2 C % 22 dm_pub_total % 22 % 3 A0 % 2 C % 22 chat_group_client % 22 % 3 A560 % 2 C % 22 allcountNum % 22 % 3 A560 % 2 C % 22 msgbox % 22 % 3 A0 % 7 D"


});*/
t = Date.now(); //看看加载需要多久。
address = system.args[1];
page.open(address, function(status) {
	if(status !== 'success') {
		console.log('FAIL to load the address');
	} else {
		t = Date.now() - t;
		//此处原来是为了提取相应的元素。只要可以用document的，还是看可以用。但是自己的无法用document，只能在用字符分割在java里。
		//  var ua = page.evaluate(function() {
		//   return document.getElementById('companyServiceMod').innerHTML;

		// });
		// fs.write("qq.html", ua, 'w');
		// console.log("测试qq: "+ua);  
		//console.log就是传输回去的内容。
		//console.log('Loading time ' + t + ' msec');
		console.log(page.content);
		setTimeout(function() {
			phantom.exit();
		}, 6000);
	}
	phantom.exit();
});