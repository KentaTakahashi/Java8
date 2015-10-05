print('called js start');

var JZonedDateTime = Java.type('java.time.ZonedDateTime');
var now = JZonedDateTime.now();	//オブジェクトの生成
print(now); //メソッドの呼び出し

print('called js end');
now;