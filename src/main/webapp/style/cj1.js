var xinm = new Array();
xinm[0] = "白金香"
xinm[1] = "白应梅"
xinm[2] = "柏仁燕"
xinm[3] = "包颜琳"
xinm[4] = "鲍学梅"
xinm[5] = "鲍  颖"
xinm[6] = "蔡玲芳"
xinm[7] = "蔡  艳"
xinm[8] = "蔡  玉"
xinm[9] = "曹发敏"

var phone = new Array();
phone[0] = "15161584615"
phone[1] = "18011111111"
phone[2] = "1581635485"
phone[3] = "13513154899"
phone[4] = "1828647913"
phone[5] = "18024631478"
phone[6] = "18631549875"
phone[7] = "18312345678"
phone[8] = "15800000000"
phone[9] = "13712365487"

var nametxt = $('.name');
var phonetxt = $('.phone');
var pcount = xinm.length-1;//参加人数
var runing = true;
var td = 10;//内定中奖,从最小奖开始，共10个名额
var num = 0;
var t;


//开始停止
function start() {
	if (runing) {
		runing = false;
		$('#btntxt').removeClass('start').addClass('stop');
		$('#btntxt').html('停止');
		startNum()
	} else {
		runing = true;
		$('#btntxt').removeClass('stop').addClass('start');
		$('#btntxt').html('开始');
		stop();
	}
}
//循环参加名单
function startNum() {
	num = Math.floor(Math.random() * pcount);
	nametxt.html(xinm[num]);
	phonetxt.html(phone[num]);
	t = setTimeout(startNum, 0);
}
//停止跳动
function stop() {
	pcount = xinm.length-1;
	clearInterval(t);
	t = 0;
}

