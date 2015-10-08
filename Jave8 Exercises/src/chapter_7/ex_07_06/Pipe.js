var pipe  = function() {
	print("test");
	$EXEC(arguments[1]);
	for (var i = 1; i < arguments.length; i++) {
		result = $EXEC(arguments[i]);
	}
};
$EXEC('sort', `ls -al`);
pipe('find .', 'grep -v class', 'sort');
