//jjs -scripting "\Users\z00s000704\git\Java8\Jave8 Exercises\src\chapter_7\ex_07_09\nextYear.js" -- 32

var num = parseInt(arguments[0]);

if(!num)
	num = parseInt($ENV.AGE);

if(!num) {
	var _in = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.System.in));
	print("How old are you ?")
	num = parseInt(new String(_in.readLine()));
}

print("Next year, you will be " + (num + 1));
