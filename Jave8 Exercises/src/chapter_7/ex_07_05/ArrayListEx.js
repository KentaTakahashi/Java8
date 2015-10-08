var newArray  = function() {
	var arr = new (Java.extend(java.util.ArrayList)) {
		add: function(x) {
			print('Adding ' + x);
			return Java.super(arr).add(x);
		}
	}
	return arr;
};

array1 = newArray();
array1.add('Fred');

array2 = newArray();
array2.add('Barney');